package EngSoftProjeto.Repositories;

import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Tarefa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TarefaRepositoryTest {


    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Test
    public void testeCriarTarefa(){


        Tarefa tf = new Tarefa();

        Empregado emp1 = new Empregado();
        emp1.setNome("Andre B");
        emp1.setCargo(Cargo.DesenvolvedorJr);

        tf.setEmpregado(emp1);
        tf.setDuracao(60);

        //Confirmar que não existe ainda
        assertEquals(0, tarefaRepository.count());
        assertEquals(0, empregadoRepository.count());

        tarefaRepository.save(tf);

        //só depois de haver tarefas no array,é que se as pode adicionar a empregado, pois vai comparar no array para ver se as contem
        emp1.addTarefa(tf);
        empregadoRepository.save(emp1);

        //Confirmar que já existem na BD
        assertEquals(1, tarefaRepository.count());
        assertEquals(1, empregadoRepository.count());

        //Confirmar que tarefa foi removida da lista do Empregado
        emp1.removeTarefa(tf);
        empregadoRepository.save(emp1);
        assertEquals(1, empregadoRepository.count());

    }
}