package EngSoftProjeto.dtos.conversores;

import EngSoftProjeto.Models.Projeto;
import EngSoftProjeto.dtos.ProjetoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ConverterDuracaoProjetoDTO implements Conversor<ProjetoResponseDTO, Projeto>{

    @Override
    public ProjetoResponseDTO converter(Projeto projeto) {
        ProjetoResponseDTO projetoResponseDTO= new ProjetoResponseDTO();
        projetoResponseDTO.setId(projeto.getId());
        projetoResponseDTO.setNome(projeto.getNome());
        projetoResponseDTO.setTarefas(projeto.getTarefas());
        projetoResponseDTO.setDuracao(projeto.duracao());
        return projetoResponseDTO;
    }
}
