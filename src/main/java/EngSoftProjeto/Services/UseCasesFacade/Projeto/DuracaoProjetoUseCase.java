package EngSoftProjeto.Services.UseCasesFacade.Projeto;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DuracaoProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public DuracaoProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Projeto> duracao(Long id) {
        try {
            int duracaoTotal = 0;
            Optional<Projeto> optionalProjeto = projetoRepository.findById(id);
            if (optionalProjeto.isPresent()) {
                Projeto projeto = optionalProjeto.get();
                for (Tarefa t : projeto.tarefas) {
                    duracaoTotal = duracaoTotal + t.getDuracao();
                }
                return Optional.of(projeto);
            }
            return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
