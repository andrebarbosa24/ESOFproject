package EngSoftProjeto.Models;

import EngSoftProjeto.Models.Empregado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @ManyToOne
  @JsonIgnore
  private Empregado empregado;

  private Integer duracao;  //duracao é minutos

  @ManyToOne
  @JsonIgnore
  private Projeto projeto;



  public int custoTarefa() {
    int custo=0;
    //passa min para horas, consideramos minimo aceitável 60 min
    int hora= duracao/60;
    custo= hora * empregado.custo(empregado.getCargo());

    return custo;
  }


}