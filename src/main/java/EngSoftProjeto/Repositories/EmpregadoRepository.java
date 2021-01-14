package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Empregado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //String pq chave primaria de Empregado é o nome pq é unico
public interface EmpregadoRepository extends CrudRepository<Empregado,Long > {
}
