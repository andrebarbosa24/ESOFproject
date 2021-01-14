package EngSoftProjeto.Services.UseCasesFacade.Projeto;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import EngSoftProjeto.Services.ProjetoService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AtualizarDuracaoTarefaUseCase {

    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;

    public AtualizarDuracaoTarefaUseCase(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Projeto> atualizaDuracaoTarefa(Long projetoId, Long tarefaId, int duracao) {
        try {
            Optional<Projeto> optionalProjeto = projetoRepository.findById(projetoId);
            if (optionalProjeto.isPresent()) {
                Projeto projeto = optionalProjeto.get();
                Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefaId);
                if (optionalTarefa.isPresent()) {
                    Tarefa tarefa = optionalTarefa.get();
                    if (projeto.tarefas.contains(tarefa)) {
                        tarefa.setDuracao(duracao);
                        return Optional.of(projeto);
                    }
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
