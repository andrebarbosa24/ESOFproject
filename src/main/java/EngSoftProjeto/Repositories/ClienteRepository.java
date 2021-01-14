package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //String pq chave primaria de Cliente é email pq é unico
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Cliente findByProjetos(String projeto);
}
