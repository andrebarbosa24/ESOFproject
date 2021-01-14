package EngSoftProjeto.dtos;


import EngSoftProjeto.Models.Cargo;
import EngSoftProjeto.Models.Empregado;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmpregadoCreateDTO implements CreateDTO<Empregado>{

        //Eliminamos o denecessário
        private Long id;
        private String nome;

        @Override
        public Empregado converter(){
            Empregado empregado = new Empregado();
            empregado.setId(id);
            empregado.setNome(this.getNome());
            return empregado;

        }

    }

