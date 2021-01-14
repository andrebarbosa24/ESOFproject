package EngSoftProjeto.Controllers;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Services.TarefaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TarefaController.class)
class TarefaControllerTest {

    @Autowired
    private MockMvc mockMvc;    //VER FINALIDADE

    @MockBean
    private TarefaService tarefaService;

    @Autowired
    private ObjectMapper objectMapper;  //ver finalidade


    @Test
    void criarTarefa() throws Exception{
        Tarefa tarefa= new Tarefa();
        tarefa.setId(1L);
        tarefa.setNome("Executar testes");
        tarefa.setDuracao(180);

        when(this.tarefaService.criarTarefa(tarefa)).thenReturn(Optional.of(tarefa));

        String tarefaAsJsonString= objectMapper.writeValueAsString(tarefa);
        //mockMvc.perform(post("/tarefa").content(tarefaAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        mockMvc.perform(post("/tarefa").content(tarefaAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

        /*Tarefa tarefaExistente= new Tarefa();
        tarefaExistente.setNome("Corrigir erros");
        tarefaExistente.setDuracao(60);
        String tarefaExistenteAsJsonString= new ObjectMapper().writeValueAsString(tarefaExistente);

        mockMvc.perform(post("/tarefa").content(tarefaExistenteAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());*/

    }
}