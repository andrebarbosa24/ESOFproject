package engsoftprojeto.repositories;

import engsoftprojeto.models.Cargo;
import engsoftprojeto.models.Empregado;
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
        emp.custo();

        Empregado emp2 = new Empregado();
        emp2.setNome("Jose N");
        emp2.setCargo(Cargo.AnalistaJr);
        emp2.custo();

        assertEquals(0, empregadoRepository.count());

        empregadoRepository.save(emp);
        empregadoRepository.save(emp2);

        assertEquals(2, empregadoRepository.count());
    }

}