package EngSoftProjeto.builder;

import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.util.ArrayList;

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
