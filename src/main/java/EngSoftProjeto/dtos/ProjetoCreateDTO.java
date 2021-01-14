package engsoftprojeto.dtos;

import engsoftprojeto.models.Projeto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ProjetoCreateDTO implements CreateDTO<Projeto>{

    @EqualsAndHashCode.Exclude
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
