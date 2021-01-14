package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProjetoRepositoryTest {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testeCriarProjeto(){

        Cliente cl1= new Cliente();
        cl1.setEmail("abcd@hohoh.com");
        cl1.setNome("Joao B");

        Projeto p1 = new Projeto();
        p1.setNome("Projeto ESOF");

        cl1.addProjeto(p1);

        assertEquals(0, projetoRepository.count());
        assertEquals(0,clienteRepository.count());

        clienteRepository.save(cl1);
        projetoRepository.save(p1);

        assertEquals(1,clienteRepository.count());
        assertEquals(1, projetoRepository.count());

    }

}