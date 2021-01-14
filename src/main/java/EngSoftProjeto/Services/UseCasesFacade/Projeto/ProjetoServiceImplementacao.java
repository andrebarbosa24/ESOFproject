package EngSoftProjeto.Services.UseCasesFacade.Projeto;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Services.ProjetoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoServiceImplementacao implements ProjetoService {

    //ESSENCIAS
    private final AtualizarDuracaoTarefaUseCase atualizarDuracaoTarefaUseCase;
    private final CriarProjetoUseCase criarProjetoUseCase;
    private final CustoProjetoUseCase custoProjetoUseCase;
    private final DuracaoProjetoUseCase duracaoProjetoUseCase;
    private final AdicionaTarefaToProjetoUseCase adicionaTarefaToProjetoUseCase;
    private final ListaTodosProjetosUseCase listaTodosProjetosUseCase;
    private final ListaPorIdProjetoUseCase listaPorIdProjetoUseCase;

    public ProjetoServiceImplementacao(AtualizarDuracaoTarefaUseCase atualizarDuracaoTarefaUseCase, CriarProjetoUseCase criarProjetoUseCase, CustoProjetoUseCase custoProjetoUseCase, DuracaoProjetoUseCase duracaoProjetoUseCase, AdicionaTarefaToProjetoUseCase adicionaTarefaToProjetoUseCase, ListaTodosProjetosUseCase listaTodosProjetosUseCase, ListaPorIdProjetoUseCase listaPorIdProjetoUseCase) {
        this.atualizarDuracaoTarefaUseCase = atualizarDuracaoTarefaUseCase;
        this.criarProjetoUseCase = criarProjetoUseCase;
        this.custoProjetoUseCase = custoProjetoUseCase;
        this.duracaoProjetoUseCase = duracaoProjetoUseCase;
        this.adicionaTarefaToProjetoUseCase = adicionaTarefaToProjetoUseCase;
        this.listaTodosProjetosUseCase = listaTodosProjetosUseCase;
        this.listaPorIdProjetoUseCase = listaPorIdProjetoUseCase;
    }

    @Override
    public  Optional<Projeto> criarProjeto(Projeto projeto){
        return criarProjetoUseCase.criarProjeto(projeto);
    }

    @Override
    public Optional<Projeto> atualizarTarefaDuracao(Long projetoId, Long tarefaId, int duracao){
        return atualizarDuracaoTarefaUseCase.atualizaDuracaoTarefa(projetoId, tarefaId, duracao);
    }

    @Override
    public Optional<Projeto> custoProjeto(Long id){
        return custoProjetoUseCase.custo(id);
    }

    @Override
    public Optional<Projeto> duracaoProjeto(Long id){
        return duracaoProjetoUseCase.duracao(id);
    }

    @Override
    public Optional<Projeto> adicionaTarefa(Long id, Tarefa tarefa){
        return  adicionaTarefaToProjetoUseCase.adicionaTarefa(id, tarefa);
    }

    @Override
    public List<Projeto> findAll() {
        return listaTodosProjetosUseCase.findAll();
    }

    @Override
    public Optional<Projeto> findById(Long id) {
        return listaPorIdProjetoUseCase.findById(id);
    }
}
