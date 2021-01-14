package EngSoftProjeto.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TarefaTest {

    @Test //Check
    void custoTarefa() {
        Tarefa tf= new Tarefa();
        tf.setDuracao(120);   //minutos

        Empregado emp= new Empregado();
        emp.setNome("Pedri");
        emp.setCargo(Cargo.DesenvolvedorJr);
        tf.setEmpregado(emp);   //atribuir EMP a tarefa

        Tarefa tf1= new Tarefa();
        tf1.setDuracao(60);
        tf1.setEmpregado(emp);

        assertEquals(20,tf.custoTarefa());
        assertEquals(10, tf1.custoTarefa());
    }
}