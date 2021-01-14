package engsoftprojeto.controllers;

import engsoftprojeto.services.TarefaService;
import engsoftprojeto.dtos.TarefaCreateDTO;
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

        TarefaCreateDTO tarefaCreateDTO= new TarefaCreateDTO();
        tarefaCreateDTO.setId(1L);
        tarefaCreateDTO.setNome("ler ler");
        tarefaCreateDTO.setDuracao(90);

        when(this.tarefaService.criarTarefa(tarefaCreateDTO.converter())).thenReturn(Optional.of(tarefaCreateDTO.converter()));

        String tarefaAsJsonString= objectMapper.writeValueAsString(tarefaCreateDTO);

        mockMvc.perform(post("/tarefa").content(tarefaAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        when(this.tarefaService.criarTarefa(tarefaCreateDTO.converter())).thenReturn(Optional.empty());

        mockMvc.perform(post("/tarefa").content(tarefaAsJsonString).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

    }
}