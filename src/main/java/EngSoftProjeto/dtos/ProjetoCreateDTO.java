package EngSoftProjeto.dtos;

import EngSoftProjeto.Models.Projeto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjetoCreateDTO implements CreateDTO<Projeto>{

    //Eliminamos o desnecessário na criação de um Projeto
    private Long id;
    private String nome;

    @Override
    public Projeto converter(){

        Projeto projeto= new Projeto();
        projeto.setId(id);
        projeto.setNome(this.getNome());
        return projeto;
    }
}
