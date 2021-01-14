package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Tarefa;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TarefaCreateDTO implements CreateDTO<Tarefa>{











    //private Long id;
    private int duracao;
    private String nome;

    @Override
    public Tarefa converter(){
        Tarefa tarefa= new Tarefa();
        tarefa.setDuracao(duracao);
        tarefa.setNome(nome);
        return tarefa;
    }
}
