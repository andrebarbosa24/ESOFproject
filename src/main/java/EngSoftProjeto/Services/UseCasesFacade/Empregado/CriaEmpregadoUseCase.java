package EngSoftProjeto.Services.UseCasesFacade.Empregado;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.EmpregadoRepository;
import EngSoftProjeto.Repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriaEmpregadoUseCase {

    private final EmpregadoRepository empregadoRepository;
    private final TarefaRepository tarefaRepository;

    @Autowired
    public CriaEmpregadoUseCase(EmpregadoRepository empregadoRepository, TarefaRepository tarefaRepository) {
        this.empregadoRepository = empregadoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Empregado> createEmpregado(Empregado empregado) {
        try {
            Optional<Empregado> optionalEmpregado = empregadoRepository.findById(empregado.getId());
            if (optionalEmpregado.isEmpty()) {
                empregadoRepository.save(empregado);
                List<Tarefa> tarefas = new ArrayList<>();

                empregado.getTarefas().forEach(tarefa -> {
                    Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefa.getId());
                    if (optionalTarefa.isPresent()) {
                        tarefas.add(tarefa);
                        tarefa.setEmpregado(empregado);
                        tarefaRepository.save(optionalTarefa.get());
                    }
                });
                empregado.setTarefas(tarefas);
                return Optional.of(empregadoRepository.save(empregado));
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
