package engsoftprojeto.dtos.conversores;

import engsoftprojeto.models.Empregado;
import engsoftprojeto.dtos.EmpregadoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterEmpregadoParaDTO implements Conversor<EmpregadoResponseDTO, Empregado> {

    @Override
    public EmpregadoResponseDTO converter(Empregado empregado) {

        EmpregadoResponseDTO empregadoResponseDTO= new EmpregadoResponseDTO();
        empregadoResponseDTO.setId(empregado.getId());
        empregadoResponseDTO.setNome(empregado.getNome());
        empregadoResponseDTO.setTarefas(empregado.getTarefas());

        return empregadoResponseDTO;
    }
}
