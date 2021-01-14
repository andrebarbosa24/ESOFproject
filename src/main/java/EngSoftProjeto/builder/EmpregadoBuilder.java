package engsoftprojeto.builder;

import engsoftprojeto.models.Cargo;
import engsoftprojeto.models.Empregado;
import engsoftprojeto.models.Tarefa;

public class EmpregadoBuilder {

    private Empregado empregado;


    public EmpregadoBuilder setNome(String nome){
        this.empregado.setNome(nome);
        return this;
    }

    public EmpregadoBuilder setCargo(Cargo cargo){
        this.empregado.setCargo(cargo);
        return this;
    }

    public EmpregadoBuilder addTarefa(Tarefa tarefa){
        this.empregado.addTarefa(tarefa);
        return this;
    }

    public Empregado build(){
        return this.empregado;

    }

    public static void main(String[] args){

      Empregado empregado= new EmpregadoBuilder().setNome("Andre").setCargo(Cargo.AnalistaJr)
              .addTarefa(new Tarefa())
              .build();


    }

}
