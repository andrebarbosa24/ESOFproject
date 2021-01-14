package engsoftprojeto.services.usecasesfacade.Projeto;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;
import engsoftprojeto.repositories.ProjetoRepository;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionaTarefaToProjetoUseCase {

    private final ProjetoRepository projetoRepository;
    private final TarefaRepository tarefaRepository;

    @Autowired
    public AdicionaTarefaToProjetoUseCase(ProjetoRepository projetoRepository, TarefaRepository tarefaRepository) {
        this.projetoRepository = projetoRepository;
        this.tarefaRepository = tarefaRepository;
    }

    public Optional<Projeto> adicionaTarefa(Long id, Tarefa tarefa) {
        try {
            Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
            if (optionalProjeto.isPresent()) {
                Projeto projeto = optionalProjeto.get();
                int numeroTarefasAntes = projeto.getTarefas().size();

                if (projeto.tarefas.contains(tarefa)) {
                    return Optional.empty();
                }
                projeto.addTarefa(tarefa);
                tarefa.setProjeto(projeto);
                tarefaRepository.save(tarefa);
                projetoRepository.save(projeto);

                int numeroTarefasDepois = projeto.getTarefas().size();

                if (numeroTarefasAntes != numeroTarefasDepois) {
                    return Optional.of(projeto);
                }
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.ofNullable(projetoRepository.findById(id)).orElseThrow(RuntimeException::new);
        }
    }
}
