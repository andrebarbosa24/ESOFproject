package EngSoftProjeto.Controllers;

import EngSoftProjeto.Models.*;
import EngSoftProjeto.Services.ProjetoService;
import EngSoftProjeto.dtos.TarefaCreateDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ProjetoController.class)
class ProjetoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjetoService projetoService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllProjetos() throws Exception {
        Projeto projeto1= new Projeto();
        Projeto projeto2= new Projeto();
        Projeto projeto3= new Projeto();

        List<Projeto> projetos= Arrays.asList(projeto1, projeto2, projeto3);

        when(projetoService.findAll()).thenReturn(projetos);

        String httpResponseAsString=mockMvc.perform(get("/projeto")).andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);

    }

    @Test
    void getProjetoById() throws Exception{

        Projeto projeto=new Projeto();

        when(projetoService.findById(1L)).thenReturn(Optional.of(projeto));

        String httpResponseAsString= mockMvc.perform(get("/projeto/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        assertNotNull(httpResponseAsString);

        mockMvc.perform(get("/projeto/2")).andExpect(status().isNotFound());

    }

    @Test
    void createProjeto() throws Exception {

        Cliente cliente= new Cliente();
        cliente.setNome("Pedro");
        cliente.setEmail("jp1234@gmail.com");

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setId(1L);
        projeto.setCliente(cliente);

        when(this.projetoService.criarProjeto(projeto)).thenReturn(Optional.of(projeto));

        String projetoJson= objectMapper.writeValueAsString(projeto);

       mockMvc.perform(
                post("/projeto")
                        .content(projetoJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect((status().isOk()));


        mockMvc.perform(
                post("/projeto")
                        .content(projetoJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect((status().isBadRequest()));

    }

    @Test
    void getCustoProjeto() throws Exception {

        Cliente cliente= new Cliente();
        cliente.setNome("Pedro");
        cliente.setEmail("jp1234@gmail.com");

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setCliente(cliente);
        projeto.setId(1L);

        Empregado empregado= new Empregado();
        empregado.setCargo(Cargo.AnalistaJr);

        Tarefa tarefa= new Tarefa();
        tarefa.setEmpregado(empregado);
        projeto.addTarefa(tarefa);

        when(projetoService.custoProjeto(1L)).thenReturn(Optional.of(projeto));

        String httpResponseAsString=mockMvc.perform(get("/projeto/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertNotNull(httpResponseAsString);

        mockMvc.perform(get("/projeto/2")).andExpect(status().isNotFound());
    }

    @Test
    void getDuracaoProjeto()throws Exception{

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setId(1L);

        Empregado empregado= new Empregado();
        empregado.setCargo(Cargo.AnalistaJr);

        Tarefa tarefa= new Tarefa();
        tarefa.setEmpregado(empregado);
        tarefa.setDuracao(120);

        tarefa.setEmpregado(empregado);
        projeto.addTarefa(tarefa);

        when(projetoService.duracaoProjeto(1L)).thenReturn(Optional.of(projeto));

        String httpResponseAsString=mockMvc.perform(get("/duracao/1")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertNotNull(httpResponseAsString);

        mockMvc.perform(get("/duracao/3")).andExpect(status().isNotFound());
    }

    @Test
    void adicionaTarefa() throws Exception {

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setId(1L);

        TarefaCreateDTO tarefa = new TarefaCreateDTO();
        //tarefa.setId(1L);
        tarefa.setDuracao(120);

        String tarefaJson= objectMapper.writeValueAsString(tarefa);

        when(projetoService.adicionaTarefa(1L,tarefa.converter())).thenReturn(Optional.of(projeto));

        mockMvc.perform(
                patch("/projeto/1/addTarefaProjeto")
                        .content(tarefaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(
                patch("/projeto/2/addTarefaProjeto")
                        .content(tarefaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

    @Test
    void atualizarTarefaDuracao() throws Exception{

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto B");
        projeto.setId(1L);

        Tarefa tarefa= new Tarefa();
        tarefa.setId(1L);
        tarefa.setDuracao(60);
        tarefa.setNome("Reler documentação");
        tarefa.setProjeto(projeto);

        projeto.addTarefa(tarefa);
        when(projetoService.atualizarTarefaDuracao(1L, 1L, 80)).thenReturn(Optional.of(projeto));

        String tarefaJson= objectMapper.writeValueAsString(tarefa);

        mockMvc.perform(
                patch("/1/atualizaTarefa")
                        .content(tarefaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(
                patch("/3/atualizaTarefa")
                        .content(tarefaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }
}