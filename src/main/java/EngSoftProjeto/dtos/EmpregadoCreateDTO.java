package engsoftprojeto.dtos;


import engsoftprojeto.models.Empregado;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class EmpregadoCreateDTO implements CreateDTO<Empregado>{



        private Long id;
        @EqualsAndHashCode.Exclude
        private String nome;

        @Override
        public Empregado converter(){
            Empregado empregado = new Empregado();
            empregado.setId(id);
            empregado.setNome(this.getNome());
            return empregado;

        }

    }

