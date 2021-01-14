package engsoftprojeto.services.usecasesfacade.Projeto;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ListaPorIdProjetoUseCase {

    private final ProjetoRepository projetoRepository;

    public ListaPorIdProjetoUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }
}
