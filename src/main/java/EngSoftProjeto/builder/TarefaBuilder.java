package EngSoftProjeto.builder;

import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.Models.Tarefa;

import java.time.Duration;

public class TarefaBuilder {

    private Tarefa tarefa;

    public TarefaBuilder setEmpregado(Empregado empregado){
        this.tarefa.setEmpregado(empregado);
        return this;
    }

    public TarefaBuilder setDuracao(int duracao){
        this.tarefa.setDuracao(duracao);
        return this;
    }
    public TarefaBuilder setProjeto(Projeto projeto){
        this.tarefa.setProjeto(projeto);
        return this;
    }

    public Tarefa build(){
        return this.tarefa;

    }

    // nao percebi muito bem o sentido desta funcao
    public static void main(String[] args){

        Tarefa tarefa= new TarefaBuilder().setEmpregado(new Empregado()).setDuracao(10).setProjeto(new Projeto()).build();
    }




}
