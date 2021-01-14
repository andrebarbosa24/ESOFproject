package engsoftprojeto.dtos;

import engsoftprojeto.models.Tarefa;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class TarefaCreateDTO implements CreateDTO<Tarefa>{



    private Long id;
    @EqualsAndHashCode.Exclude
    private int duracao;
    @EqualsAndHashCode.Exclude
    private String nome;

    @Override
    public Tarefa converter(){
        Tarefa tarefa= new Tarefa();
        tarefa.setId(id);
        tarefa.setDuracao(duracao);
        tarefa.setNome(nome);
        return tarefa;
    }
}
