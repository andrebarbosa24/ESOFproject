package EngSoftProjeto.Models;

import EngSoftProjeto.Services.EmpregadoService;
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
@EqualsAndHashCode  //adicionado
public class Empregado {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Transient
  @JsonIgnore
  private Cargo cargo;


  @OneToMany(mappedBy = "empregado")
  @JsonIgnore
  public List<Tarefa> tarefas= new ArrayList<>();


  //retorna valor-hora de um empregado
  public int custo(Cargo cg) {
    int horaValor;
    switch (cg){
      case DesenvolvedorJr:
        horaValor=cargo.DesenvolvedorJr.getSalarioHora();
        break;

      case DesenvolvedorSr:
        horaValor=cargo.DesenvolvedorSr.getSalarioHora();
        break;

      case AnalistaJr:
        horaValor=cargo.AnalistaJr.getSalarioHora();
        break;

      case AnalistaSr:
        horaValor=cargo.AnalistaSr.getSalarioHora();
        break;

        default:
          System.out.println("Cargo nao existente!");
          return 0;
    }
    return horaValor;
  }


  //Get's e Set's
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setCargo(Cargo cargo){ this.cargo= cargo;}

  public Cargo getCargo() {
    return cargo;
  }

  //Adicionar tarefa a lista
  public void addTarefa(Tarefa tf)
  {
    if(!tarefas.contains(tf)){
      tarefas.add(tf);
      tf.setEmpregado(this);
    }
  }

  //Remover tarefa da lista
  public void removeTarefa(Tarefa tf)
  {
    if(tarefas.contains(tf)){
      tarefas.remove(tf);
    }
  }

}