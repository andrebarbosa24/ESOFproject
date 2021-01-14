package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ClienteRepositoryTest {

    @Autowired  //instaciar a variavel, não é necessário fazer new ClienteRep
    private ClienteRepository clienteRepository;

    //TESTE adiciaonar cliente a BD
    @Test
    public void testCriarCliente(){
        Cliente cl= new Cliente();
        cl.setEmail("abcd@hohoh.com");
        cl.setNome("Joao B");

        assertEquals(0, clienteRepository.count());

        //adicionar a BD
        clienteRepository.save(cl);
        //verificar se adicionou à BD(adicionamos 1 cliente logo expected=1)
        assertEquals(1, clienteRepository.count());
    }

}