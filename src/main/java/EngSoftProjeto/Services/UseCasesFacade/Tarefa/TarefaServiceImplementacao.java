package EngSoftProjeto.Services.UseCasesFacade.Tarefa;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Services.TarefaService;
import org.springframework.stereotype.Service;

import java.util.List;
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
