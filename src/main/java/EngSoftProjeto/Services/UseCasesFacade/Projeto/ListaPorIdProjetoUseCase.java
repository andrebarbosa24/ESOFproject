package EngSoftProjeto.Services.UseCasesFacade.Projeto;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Repositories.ProjetoRepository;
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
