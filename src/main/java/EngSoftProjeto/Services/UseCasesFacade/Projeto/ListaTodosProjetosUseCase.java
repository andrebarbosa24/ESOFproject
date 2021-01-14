package engsoftprojeto.services.usecasesfacade.Projeto;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.repositories.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaTodosProjetosUseCase {

    private final ProjetoRepository projetoRepository;

    public ListaTodosProjetosUseCase(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    public List<Projeto> findAll() {
        List<Projeto> projetos=new ArrayList<>();
        projetoRepository.findAll().forEach(projetos::add);
        return projetos;
    }
}
