package engsoftprojeto.dtos.conversores;

import engsoftprojeto.models.Tarefa;
import engsoftprojeto.dtos.TarefaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterTarefaParaDTO implements Conversor<TarefaResponseDTO, Tarefa> {







    @Override
    public TarefaResponseDTO converter(Tarefa tarefa) {

        TarefaResponseDTO tarefaResponseDTO= new TarefaResponseDTO();
        tarefaResponseDTO.setId(tarefa.getId());
        tarefaResponseDTO.setDuracao(tarefa.getDuracao());
        tarefaResponseDTO.setNome(tarefa.getNome());
        return tarefaResponseDTO;
    }
}
