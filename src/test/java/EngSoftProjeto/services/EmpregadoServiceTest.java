package EngSoftProjeto.services;


import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Services.EmpregadoService;
import EngSoftProjeto.Services.UseCasesFacade.Empregado.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = EmpregadoServiceImplementacao.class)
class EmpregadoServiceTest {

    @Autowired
    private EmpregadoService empregadoService;

    @MockBean
    private AdicionaTarefaUseCase adicionaTarefaUseCase;

    @MockBean
    private CriaEmpregadoUseCase criaEmpregadoUseCase;

    @MockBean
    private AtualizarTarefaDuracaoUseCase atualizarTarefaDuracaoUseCase;

    @MockBean
    private RemoverTarefaUseCase removerTarefaUseCase;



    @Test
    void criarEmpregado(){

        Empregado empregado= new Empregado();
        empregado.setNome("Nuno");
        empregado.setCargo(Cargo.DesenvolvedorJr);

        when(criaEmpregadoUseCase.createEmpregado(empregado)).thenReturn(Optional.of(empregado));

        assertTrue(empregadoService.criaEmpregado(empregado).isPresent());

    }

    @Test
    void adicionaTarefa(){

        Empregado empregado= new Empregado();
        empregado.setNome("Nuno");
        empregado.setCargo(Cargo.DesenvolvedorJr);

        Tarefa tarefa= new Tarefa();
        tarefa.setId((long)1);
        tarefa.setDuracao(120);

        empregado.addTarefa(tarefa);

        when(adicionaTarefaUseCase.adicionaTarefa(empregado.getId(), tarefa)).thenReturn(Optional.of(empregado));

        assertTrue(empregadoService.adicionaTarefa(empregado.getId(), tarefa).isPresent());

    }

    @Test
    void atualizaTarefaDuracao(){

        Empregado empregado= new Empregado();
        empregado.setNome("Nuno");
        empregado.setCargo(Cargo.DesenvolvedorJr);

        Tarefa tarefa= new Tarefa();
        empregado.addTarefa(tarefa);

        if(empregado.tarefas.contains(tarefa)){
            tarefa.setDuracao(20);
        }

        when(atualizarTarefaDuracaoUseCase.atualizaTarefa(empregado.getId(),tarefa.getId(),20)).thenReturn(Optional.of(empregado));
        assertTrue(empregadoService.atualizarTarefaDuracao(empregado.getId(), tarefa.getId(), 20 ).isPresent());

    }

    @Test
    void removerTarefa(){

        Empregado empregado= new Empregado();
        empregado.setNome("Nuno");
        empregado.setCargo(Cargo.DesenvolvedorJr);

        Tarefa tarefa= new Tarefa();
        tarefa.setId((long)1);
        tarefa.setDuracao(120);

        empregado.removeTarefa(tarefa);

        when(removerTarefaUseCase.removerTarefa(empregado.getId(), tarefa.getId())).thenReturn(Optional.of(empregado));
        assertTrue(empregadoService.removerTarefa(empregado.getId(), tarefa.getId()).isPresent());
    }

}
