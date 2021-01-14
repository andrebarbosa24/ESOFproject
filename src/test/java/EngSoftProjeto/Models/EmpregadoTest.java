package EngSoftProjeto.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpregadoTest {

    @Test
    void custo() {

        Empregado emp1= new Empregado();
        emp1.setNome("Joao P");
        emp1.setCargo(Cargo.DesenvolvedorJr);

        //Prints
        String nome= emp1.getNome();
        Cargo carg= emp1.getCargo();
        System.out.println(nome);
        System.out.println(carg);

        Empregado emp2= new Empregado();
        emp2.setNome("Brunono");
        emp2.setCargo(Cargo.AnalistaSr);

        assertEquals(10,emp1.custo(emp1.getCargo()));
        assertEquals(80,emp2.custo(emp2.getCargo()) );

        Empregado emp3= new Empregado();
        emp3.setNome("Leo");
        emp3.setCargo(Cargo.CEO);

        assertEquals(0, emp3.custo(emp3.getCargo()));
    }
}