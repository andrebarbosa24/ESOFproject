package engsoftprojeto;

import engsoftprojeto.models.*;
import engsoftprojeto.repositories.ClienteRepository;
import engsoftprojeto.repositories.EmpregadoRepository;
import engsoftprojeto.repositories.ProjetoRepository;
import engsoftprojeto.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Inicializacao implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;



    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

       /* Cliente */

        Cliente cl= new Cliente();
        cl.setEmail("abcd@hohoh.com");
        cl.setNome("Joao B");

        clienteRepository.save(cl);


        /* Projeto */

        Projeto p1 = new Projeto();
        p1.setNome("Projeto ESOF");
        p1.setCliente(cl);

        Projeto p2= new Projeto();
        p2.setNome("Projeto ABC");
        p2.setCliente(cl);


        /* Empregado    */

        Empregado emp = new Empregado();
        emp.setNome("Andre B");
        emp.setCargo(Cargo.DesenvolvedorJr);
        emp.custo();

        empregadoRepository.save(emp);

        Empregado emp1 = new Empregado();
        emp1.setNome("Jose N");
        emp1.setCargo(Cargo.AnalistaJr);

        empregadoRepository.save(emp1);

        Empregado emp2 = new Empregado();
        emp2.setNome("Joao F");
        emp2.setCargo(Cargo.DesenvolvedorSr);
        emp2.custo();

        empregadoRepository.save(emp2);


        /* Tarefa */

        Tarefa tf = new Tarefa();
        tf.setEmpregado(emp);
        tf.setDuracao(60);
        tf.setNome("Executar testes de repositiorios");
        tf.setEmpregado(emp);
        //tarefaRepository.save(tf);
        //emp.addTarefa(tf);

        Tarefa tf1 = new Tarefa();
        tf1.setEmpregado(emp1);
        tf1.setDuracao(90);
        tf1.setNome("Executar testes de servicos");
        tf1.setEmpregado(emp1);
        //tarefaRepository.save(tf1);

        Tarefa tf2 = new Tarefa();
        tf2.setEmpregado(emp2);
        tf2.setDuracao(180);
        tf1.setNome("Executar testes de controladores");
        //tarefaRepository.save(tf2);

        //Save projetos para a BD
        projetoRepository.save(p1);
        projetoRepository.save(p2);

        //Adiciona tarefas a projetos
        p1.addTarefa(tf);
        p1.addTarefa(tf1);
        p1.addTarefa(tf2);

        p2.addTarefa(tf1);
        p2.addTarefa(tf2);

        projetoRepository.save(p1);
        projetoRepository.save(p2);

    }
}
