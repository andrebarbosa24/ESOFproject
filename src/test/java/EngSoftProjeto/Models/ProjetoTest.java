package EngSoftProjeto.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjetoTest {


    @Test
    void custoProjeto() {
        Cliente cl= new Cliente();
        cl.setNome("Joao");
        cl.setEmail("jp1234@gmail.com");

        Projeto p1= new Projeto();
        p1.setNome("Projeto A");
        p1.setCliente(cl);
        p1.setId(1L);

        //Prints
        String nome= p1.getNome();
        System.out.println(nome);
        Cliente clt= p1.getCliente();
        System.out.println(clt.getNome());

        Empregado emp=new Empregado();
        emp.setNome("Analistajunior");
        emp.setCargo(Cargo.DesenvolvedorJr);

        Tarefa t=new Tarefa();
        t.setDuracao(120);
        t.setEmpregado(emp);
        long aux=12;
        t.setId(aux);

        p1.addTarefa(t);
        assertEquals(20,p1.custoProjeto());

        p1.removeTarefa(t);
        assertEquals(0, p1.custoProjeto());
    }

    @Test
    void duracao() {
        Cliente cl= new Cliente();
        cl.setNome("Joao");
        cl.setEmail("jp1234@gmail.com");

        Projeto p1= new Projeto();
        p1.setNome("Projeto A");
        p1.setCliente(cl);


        Empregado emp=new Empregado();
        emp.setNome("Analistajunior");
        emp.setCargo(Cargo.DesenvolvedorJr);

        Tarefa t=new Tarefa();
        t.setDuracao(120);
        t.setEmpregado(emp);
        t.setId((long)12);

        p1.addTarefa(t);
        assertEquals(120, p1.duracao()); // mudar para equals

        p1.removeTarefa(t);
        assertEquals(0, p1.duracao());
    }
}