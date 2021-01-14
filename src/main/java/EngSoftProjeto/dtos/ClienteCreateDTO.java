package EngSoftProjeto.dtos;


import EngSoftProjeto.Models.Cliente;
import EngSoftProjeto.Models.Projeto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO implements CreateDTO<Cliente> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private String email;

    @Override
    public Cliente converter(){

        logger.info("Convertido para Modelo");

        Cliente cliente = new Cliente();
        cliente.setEmail(this.getEmail());
        return cliente;

    }
}
