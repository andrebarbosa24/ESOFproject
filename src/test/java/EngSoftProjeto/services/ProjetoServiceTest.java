package EngSoftProjeto.services;


import EngSoftProjeto.Models.*;
import EngSoftProjeto.Services.ProjetoService;
import EngSoftProjeto.Services.UseCasesFacade.Projeto.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = ProjetoServiceImplementacao.class)
class ProjetoServiceTest {

    @Autowired
    private ProjetoService projetoService;

    @MockBean
    private CriarProjetoUseCase criarProjetoUseCase;

    @MockBean
    private AtualizarDuracaoTarefaUseCase atualizarDuracaoTarefaUseCase;

    @MockBean
    private DuracaoProjetoUseCase duracaoProjetoUseCase;

    @MockBean
    private CustoProjetoUseCase custoProjetoUseCase;

    @MockBean
    private AdicionaTarefaToProjetoUseCase adicionaTarefaToProjetoUseCase;

    @MockBean
    private ListaPorIdProjetoUseCase listaPorIdProjetoUseCase;

    @MockBean
    private ListaTodosProjetosUseCase listaTodosProjetosUseCase;

    @Test
    void criarProjeto(){

        Cliente cliente= new Cliente();
        cliente.setNome("Pedro");
        cliente.setEmail("jp1234@gmail.com");

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setCliente(cliente);

        projeto.setCliente(cliente);

        when(criarProjetoUseCase.criarProjeto(projeto)).thenReturn(Optional.of(projeto));

        assertTrue(projetoService.criarProjeto(projeto).isPresent());

    }

    @Test
    void atualizarTarefaDuracao(){

        Cliente cliente= new Cliente();
        cliente.setNome("Pedro");
        cliente.setEmail("jp1234@gmail.com");

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setCliente(cliente);
        projeto.setId(1L);

        Tarefa tarefa= new Tarefa();
        projeto.addTarefa(tarefa);

        if(projeto.tarefas.contains(tarefa)){
            tarefa.setDuracao(20);
        }

        when(atualizarDuracaoTarefaUseCase.atualizaDuracaoTarefa(projeto.getId(),tarefa.getId(),20)).thenReturn(Optional.of(projeto));
        assertTrue(projetoService.atualizarTarefaDuracao(projeto.getId(),tarefa.getId(),20).isPresent());

    }

    @Test
    void custoProjeto(){

        Cliente cliente= new Cliente();
        cliente.setNome("Pedro");
        cliente.setEmail("jp1234@gmail.com");

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setCliente(cliente);
        projeto.setId(1L);

        Empregado empregado= new Empregado();
        empregado.setCargo(Cargo.AnalistaJr);

        Tarefa tarefa= new Tarefa();
        tarefa.setEmpregado(empregado);
        projeto.addTarefa(tarefa);

        when(custoProjetoUseCase.custo(projeto.getId())).thenReturn(Optional.of(projeto));
        assertTrue(projetoService.custoProjeto(projeto.getId()).isPresent());

    }
    @Test
    void duracaoProjeto(){
        Cliente cliente= new Cliente();
        cliente.setNome("Pedro");
        cliente.setEmail("jp1234@gmail.com");

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setCliente(cliente);
        projeto.setId(1L);

        Empregado empregado= new Empregado();
        empregado.setCargo(Cargo.AnalistaJr);

        Tarefa tarefa= new Tarefa();
        tarefa.setEmpregado(empregado);
        projeto.addTarefa(tarefa);
        tarefa.setDuracao(20);

        when(duracaoProjetoUseCase.duracao(projeto.getId())).thenReturn(Optional.of(projeto));
        assertTrue(projetoService.duracaoProjeto(projeto.getId()).isPresent());
    }

    @Test
    void addTarefaToProjeto(){

        Projeto projeto= new Projeto();
        projeto.setNome("Projeto A");
        projeto.setId(1L);

        Tarefa tarefa= new Tarefa();
        tarefa.setId((long)1);
        tarefa.setDuracao(120);

        projeto.addTarefa(tarefa);

        when(adicionaTarefaToProjetoUseCase.adicionaTarefa(projeto.getId(), tarefa)).thenReturn(Optional.of(projeto));

        assertTrue(projetoService.adicionaTarefa(projeto.getId(), tarefa).isPresent());
    }

    @Test
    void findById() {

        when(listaPorIdProjetoUseCase.findById(1L)).thenReturn(Optional.of(new Projeto()));
        assertTrue(projetoService.findById(1L).isPresent());
        assertTrue(projetoService.findById(2L).isEmpty());
    }

    @Test
    void findAll() {
        when(listaTodosProjetosUseCase.findAll()).thenReturn(new ArrayList<>());
        assertNotNull(projetoService.findAll());
    }
}