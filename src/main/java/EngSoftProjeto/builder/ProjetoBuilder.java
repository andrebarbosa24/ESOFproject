package engsoftprojeto.builder;

import engsoftprojeto.models.Cliente;
import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;

public class ProjetoBuilder {
    private Projeto projeto;

    public ProjetoBuilder setNome(String nome){
        this.projeto.setNome(nome);
        return this;
    }

    public ProjetoBuilder setCliente(Cliente cliente){
        this.projeto.setCliente(cliente);
        return this;
    }


    public ProjetoBuilder addTarefa(Tarefa tarefa){
        this.projeto.addTarefa(tarefa);
        return this;
    }


    public Projeto build(){
        return this.projeto;

    }

    // nao percebi muito bem o sentido desta funcao
    public static void main(String[] args){
      /*  Tarefa t1= new Tarefa();
        Cliente c=new Cliente();
        Projeto projeto= new ProjetoBuilder(12,"projeto bonito",c,t1).build();*/

        Projeto projeto=new ProjetoBuilder().setNome("projeto").setCliente(new Cliente())
                .addTarefa(new Tarefa())
                .build();

    }
}
