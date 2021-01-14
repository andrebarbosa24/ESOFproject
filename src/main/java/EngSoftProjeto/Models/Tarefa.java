package engsoftprojeto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Tarefa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @ManyToOne
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  private Empregado empregado;

  private Integer duracao;  //duracao é minutos

  @ManyToOne
  @JsonIgnore
  @EqualsAndHashCode.Exclude
  private Projeto projeto;



  public int custoTarefa() {
    int custo=0;
    int hora= duracao/60;
    if(this.empregado!=null) {
      custo = hora * empregado.custo();
    }

    return custo;
  }


}