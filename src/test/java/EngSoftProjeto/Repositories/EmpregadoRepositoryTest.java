package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmpregadoRepositoryTest {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Test
    public void testCriarEmpregado(){

        Empregado emp = new Empregado();
        emp.setNome("Andre B");
        emp.setCargo(Cargo.DesenvolvedorJr);
        emp.custo(emp.getCargo());

        Empregado emp2 = new Empregado();
        emp2.setNome("Jose N");
        emp2.setCargo(Cargo.AnalistaJr);
        emp2.custo(emp2.getCargo());

        assertEquals(0, empregadoRepository.count());

        empregadoRepository.save(emp);
        empregadoRepository.save(emp2);

        assertEquals(2, empregadoRepository.count());
    }

}