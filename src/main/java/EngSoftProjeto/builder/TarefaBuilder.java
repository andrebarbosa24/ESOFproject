package engsoftprojeto.builder;

import engsoftprojeto.models.Empregado;
import engsoftprojeto.models.Projeto;
import engsoftprojeto.models.Tarefa;

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
