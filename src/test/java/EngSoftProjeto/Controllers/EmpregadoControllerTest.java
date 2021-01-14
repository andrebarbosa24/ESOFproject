package EngSoftProjeto.Controllers;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.EmpregadoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import EngSoftProjeto.Services.EmpregadoService;
import EngSoftProjeto.dtos.EmpregadoCreateDTO;
import EngSoftProjeto.dtos.TarefaCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmpregadoController.class)
class EmpregadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpregadoService empregadoService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void criarEmpregado() throws Exception {

        Empregado empregado= new Empregado();
        empregado.setId(1L);
        empregado.setNome("Joao B");

        //
        when(this.empregadoService.criaEmpregado(empregado)).thenReturn(Optional.of(empregado));

        String empregadoAsJsonString= objectMapper.writeValueAsString(empregado);


        mockMvc.perform(post("/empregado").content(empregadoAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        //mockMvc.perform(post("/empregado").content(empregadoAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

       Empregado empregadoExistente= new Empregado();
        empregadoExistente.setNome("Joao C");
        empregadoExistente.setId(2L);

        String empregadoExistenteAsJsonString= objectMapper.writeValueAsString(empregadoExistente);
        mockMvc.perform(post("/empregado").content(empregadoExistenteAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Test
    void adicionaTarefa() throws Exception{

        EmpregadoCreateDTO empregado= new EmpregadoCreateDTO();
        empregado.setNome("Joao A");
        empregado.setId(1L);

        TarefaCreateDTO tarefa= new TarefaCreateDTO();
        tarefa.setNome("redigir relatorio");
        tarefa.setDuracao(60);
        //tarefa.setId(1L);

        String tarefaJson= objectMapper.writeValueAsString(tarefa);

        when(empregadoService.adicionaTarefa(1L, tarefa.converter())).thenReturn(Optional.empty());

        mockMvc.perform(patch("/empregado/1/addTarefaEmpregado")
                        .content(tarefaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mockMvc.perform(patch("/empregado/2/addTarefaEmpregado")
                .content(tarefaJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());

    }
}