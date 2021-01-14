package engsoftprojeto.services;

import engsoftprojeto.models.Tarefa;
import engsoftprojeto.services.usecasesfacade.Tarefa.CriarTarefaUseCase;
import engsoftprojeto.services.usecasesfacade.Tarefa.TarefaServiceImplementacao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = TarefaServiceImplementacao.class)
class TarefaServiceTest {

    @Autowired
    private TarefaService tarefaService;

    @MockBean
    private CriarTarefaUseCase criarTarefaUseCase;

    @Test
    void criarTarefa(){

        Tarefa tarefa= new Tarefa();
        tarefa.setDuracao(120);

        //Interage com o método do caso de uso
        when(criarTarefaUseCase.createTarefa(tarefa)).thenReturn(Optional.of(tarefa));
        //interage diretamente com o serviço
        assertTrue(tarefaService.criarTarefa(tarefa).isPresent());

    }

}