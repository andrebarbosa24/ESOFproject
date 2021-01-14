package engsoftprojeto.services.usecasesfacade.Empregado;

import engsoftprojeto.models.Empregado;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.EmpregadoRepository;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoverTarefaUseCase {

    private final EmpregadoRepository empregadoRepository;
    private final TarefaRepository tarefaRepository;

    public RemoverTarefaUseCase(EmpregadoRepository empregadoRepository, TarefaRepository tarefaRepository) {
        this.empregadoRepository = empregadoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Empregado> removerTarefa(Long empregadoId, Long tarefaId) {
        try {
            Optional<Empregado> optionalEmpregado = empregadoRepository.findById(empregadoId);
            if (optionalEmpregado.isPresent()) {
                Empregado empregado = optionalEmpregado.get();
                Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefaId);
                if (optionalTarefa.isPresent()) {
                    Tarefa tarefa = optionalTarefa.get();
                    empregado.removeTarefa(tarefa);
                    return Optional.of(empregado);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
