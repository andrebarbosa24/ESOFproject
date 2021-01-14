package engsoftprojeto.services.usecasesfacade.Empregado;

import engsoftprojeto.models.Empregado;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.EmpregadoRepository;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaTarefaUseCase {

    private final EmpregadoRepository empregadoRepository;
    private final TarefaRepository tarefaRepository;

    @Autowired
    public AdicionaTarefaUseCase(EmpregadoRepository empregadoRepository, TarefaRepository tarefaRepository) {
        this.empregadoRepository = empregadoRepository;
        this.tarefaRepository = tarefaRepository;
    }


    public Optional<Empregado> adicionaTarefa(Long empregadoId, Tarefa tarefa) {
        try{
            Optional<Empregado> optionalEmpregado = this.empregadoRepository.findById(empregadoId);
            if (optionalEmpregado.isPresent()) {
                Empregado empregado = optionalEmpregado.get();
                int numeroTarefasAntes = empregado.getTarefas().size();

                if (empregado.tarefas.contains(tarefa)) { //verificar se tarefa já existe
                    return Optional.empty();
                }
                empregado.addTarefa(tarefa);
                tarefa.setEmpregado(empregado);
                tarefaRepository.save(tarefa);
                empregadoRepository.save(empregado);

                int numeroTarefasDepois = empregado.getTarefas().size();
                if (numeroTarefasAntes != numeroTarefasDepois) {
                    return Optional.of(empregado);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.ofNullable(empregadoRepository.findById(empregadoId)).orElseThrow(RuntimeException::new);
        }
    }
}
