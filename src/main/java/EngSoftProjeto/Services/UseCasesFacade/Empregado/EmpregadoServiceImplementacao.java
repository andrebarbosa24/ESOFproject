package EngSoftProjeto.Services.UseCasesFacade.Empregado;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Services.EmpregadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpregadoServiceImplementacao implements EmpregadoService {

    private final AtualizarTarefaDuracaoUseCase atualizarTarefaDuracaoUseCase;
    private final RemoverTarefaUseCase removerTarefaUseCase;
    private final CriaEmpregadoUseCase criaEmpregadoUseCase;
    private final AdicionaTarefaUseCase adicionaTarefaUseCase;

    public EmpregadoServiceImplementacao(AtualizarTarefaDuracaoUseCase atualizarTarefaDuracaoUseCase, RemoverTarefaUseCase removerTarefaUseCase, CriaEmpregadoUseCase criaEmpregadoUseCase, AdicionaTarefaUseCase adicionaTarefaUseCase) {
        this.atualizarTarefaDuracaoUseCase = atualizarTarefaDuracaoUseCase;
        this.removerTarefaUseCase = removerTarefaUseCase;
        this.criaEmpregadoUseCase = criaEmpregadoUseCase;
        this.adicionaTarefaUseCase = adicionaTarefaUseCase;
    }

    @Override
    public Optional<Empregado> criaEmpregado(Empregado converter){
        return criaEmpregadoUseCase.createEmpregado(converter);
    }

    @Override
    public  Optional<Empregado> adicionaTarefa(Long empregadoId, Tarefa tarefa){
        return adicionaTarefaUseCase.adicionaTarefa(empregadoId,tarefa);
    }

    @Override
    public Optional<Empregado> atualizarTarefaDuracao(Long empregadoId, Long tarefaId, int duracao){
        return atualizarTarefaDuracaoUseCase.atualizaTarefa(empregadoId, tarefaId, duracao);
    }

    @Override
    public Optional<Empregado> removerTarefa(Long empregadoId, Long tarefaId){
        return removerTarefaUseCase.removerTarefa(empregadoId, tarefaId);
    }

}
