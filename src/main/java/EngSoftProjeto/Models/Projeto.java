package EngSoftProjeto.Models;

import EngSoftProjeto.Models.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Projeto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Exclude
  private Long id;

  private String nome;

  @ManyToOne
  private Cliente cliente;


  @OneToMany(mappedBy = "projeto",cascade = CascadeType.ALL)
  public List<Tarefa> tarefas =new ArrayList<>();


  public int custoProjeto( ){
    int custo=0;

    for(Tarefa tarefaActual: tarefas){
      custo+= tarefaActual.custoTarefa();
    }
    return custo;
  }

  public int duracao() {

    int somatorioDuracao=0;
    for(Tarefa t: tarefas){
      somatorioDuracao+= t.getDuracao();
    }
    return somatorioDuracao;
  }

  //Get's e Set's
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


    //Adicionar tarefa a lista
    public void addTarefa(Tarefa tarefa)
    {
        if(!tarefas.contains(tarefa)){
            tarefas.add(tarefa);
            tarefa.setProjeto(this);
        }
    }

    //Remover tarefa da lista
    public void removeTarefa(Tarefa tarefa)
    {
        if(tarefas.contains(tarefa)){
            tarefas.remove(tarefa);
        }
    }

}