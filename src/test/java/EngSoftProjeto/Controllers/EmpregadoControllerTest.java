package engsoftprojeto.controllers;

import engsoftprojeto.models.Empregado;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.services.EmpregadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

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

        when(this.empregadoService.criaEmpregado(empregado)).thenReturn(Optional.of(empregado));

        String empregadoAsJsonString= objectMapper.writeValueAsString(empregado);

        mockMvc.perform(post("/empregado").content(empregadoAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        when(this.empregadoService.criaEmpregado(empregado)).thenReturn(Optional.empty());

        mockMvc.perform(post("/empregado").content(empregadoAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }

    @Test
    void adicionaTarefa() throws Exception{

        Empregado empregado= new Empregado();
        empregado.setNome("Joao A");
        empregado.setId(1L);

        Tarefa tarefa= new Tarefa();
        tarefa.setNome("redigir relatorio");
        tarefa.setDuracao(60);

        String tarefaJson= objectMapper.writeValueAsString(tarefa);

        when(empregadoService.adicionaTarefa(1L, tarefa)).thenReturn(Optional.of(empregado));

        //Testes HTTP com Mock
        mockMvc.perform(patch("/empregado/1/addTarefaEmpregado")
                        .content(tarefaJson)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        when(empregadoService.adicionaTarefa(1L, tarefa)).thenReturn(Optional.empty());

        mockMvc.perform(patch("/empregado/5/addTarefaEmpregado")
                .content(tarefaJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());

    }
}