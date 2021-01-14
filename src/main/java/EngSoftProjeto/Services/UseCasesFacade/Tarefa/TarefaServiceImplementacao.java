package engsoftprojeto.services.usecasesfacade.Tarefa;

import engsoftprojeto.models.Tarefa;
import engsoftprojeto.services.TarefaService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaServiceImplementacao implements TarefaService {

    //ESSENCIAIS
    private final CriarTarefaUseCase criarTarefaUseCase;

    public TarefaServiceImplementacao(CriarTarefaUseCase criarTarefaUseCase) {
        this.criarTarefaUseCase = criarTarefaUseCase;
    }

    @Override
    public Optional<Tarefa> criarTarefa(Tarefa converter){
        return criarTarefaUseCase.createTarefa(converter);
    }

}
