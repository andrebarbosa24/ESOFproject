package EngSoftProjeto.dtos.conversores;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.dtos.EmpregadoResponseDTO;
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
