package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Projeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {

}
