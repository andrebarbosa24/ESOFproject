package engsoftprojeto.services.usecasesfacade.Tarefa;

import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarTarefaUseCase {

    private final TarefaRepository tarefaRepository;

    @Autowired
    public CriarTarefaUseCase(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Tarefa> createTarefa(Tarefa tarefa) {
        try {
            Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefa.getId());
            if (optionalTarefa.isEmpty()) {
                return Optional.of(tarefaRepository.save(tarefa));
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
