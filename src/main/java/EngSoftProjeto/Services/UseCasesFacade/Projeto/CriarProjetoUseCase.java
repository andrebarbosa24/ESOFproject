package engsoftprojeto.services.usecasesfacade.Projeto;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.ProjetoRepository;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CriarProjetoUseCase {

    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;


    public CriarProjetoUseCase(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Projeto> criarProjeto(Projeto projeto) {
        try {
            Optional<Projeto> optionalProjeto = projetoRepository.findById(projeto.getId());
            if (optionalProjeto.isEmpty()) {
                List<Tarefa> tarefas = new ArrayList<>();
                projeto.getTarefas().forEach(tarefa -> {
                    Optional<Tarefa> optionalTarefa = tarefaRepository.findById(tarefa.getId());
                    if (optionalTarefa.isPresent()) {
                        tarefas.add(tarefa);
                        projeto.addTarefa(tarefa);
                    }
                });
                projeto.setTarefas(tarefas);
                return Optional.of(projetoRepository.save(projeto));
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
