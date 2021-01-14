package EngSoftProjeto.Services;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.List;
import java.util.Optional;

public interface ProjetoService {

    List<Projeto> findAll();
    Optional<Projeto> findById(Long id);
    Optional<Projeto> criarProjeto(Projeto converter);
    Optional<Projeto> atualizarTarefaDuracao(Long projetoId, Long tarefaId, int duracao);
    Optional<Projeto> custoProjeto(Long id);
    Optional<Projeto> duracaoProjeto(Long id);
    Optional<Projeto> adicionaTarefa(Long id, Tarefa tarefa);


}
