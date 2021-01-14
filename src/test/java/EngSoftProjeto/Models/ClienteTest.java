package EngSoftProjeto.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void consultarCustoProjeto() {
        Cliente cl= new Cliente();
        cl.setNome("Joao");
        cl.setEmail("jp1234@gmail.com");

        //Prints
        String mail= cl.getEmail();
        System.out.println(mail);



        Empregado emp=new Empregado();
        emp.setNome("Analistajunior");
        emp.setCargo(Cargo.DesenvolvedorJr);

        Empregado emp1=new Empregado();
        emp1.setNome("Analistajunior");
        emp1.setCargo(Cargo.AnalistaJr);

        Tarefa t=new Tarefa();
        t.setDuracao(60);
        t.setEmpregado(emp1);
        long aux=12;
        t.setId(aux);

        Projeto p1= new Projeto();
        p1.setNome("Projeto A");
        cl.addProjeto(p1);
        p1.addTarefa(t);

        Projeto p2= new Projeto();
        p2.setNome("Projeto B");

        //cl.addProjeto(p2);
        assertEquals(0, cl.consultarCustoProjeto(p2));

        p1.addTarefa(t);
        assertEquals(20,cl.consultarCustoProjeto(p1));

        p1.removeTarefa(t);
        assertEquals(0, cl.consultarCustoProjeto(p1));



    }

    @Test
    void consultarDuracaoProjeto() {

        Cliente cl= new Cliente();
        cl.setNome("Brubru");
        cl.setEmail("bruno99@gmail.com");

        Empregado emp= new Empregado();
        emp.setNome("Joao");
        emp.setCargo(Cargo.DesenvolvedorJr);

        Tarefa t= new Tarefa();
        t.setDuracao(120);
        t.setEmpregado(emp);
        t.setId((long)2);

        Tarefa t1= new Tarefa();
        t1.setDuracao(60);
        t1.setEmpregado(emp);
        t1.setId((long)3);

        Tarefa t2= new Tarefa();
        t2.setDuracao(120);
        t2.setEmpregado(emp);
        t2.setId((long)4);

        Projeto p1= new Projeto();
        p1.setNome("Projeto A");
        cl.addProjeto(p1);

        p1.addTarefa(t);
        p1.addTarefa(t1);

        p1.addTarefa(t2);
        p1.removeTarefa(t2);

        assertEquals(180, cl.consultarDuracaoProjeto(p1));

        //PORQUE NAO COBRE AQUI?
        cl.removeProjeto(p1);
        assertEquals(0, cl.consultarDuracaoProjeto(p1));


    }
}