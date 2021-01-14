package engsoftprojeto.dtos;

import engsoftprojeto.models.Tarefa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpregadoResponseDTO {

    private Long id;
    private String nome;
    private List<Tarefa> tarefas= new ArrayList<>();

}
