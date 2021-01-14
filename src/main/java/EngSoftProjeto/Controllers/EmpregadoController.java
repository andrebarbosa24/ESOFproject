package EngSoftProjeto.Controllers;

import EngSoftProjeto.Models.Empregado;
import EngSoftProjeto.Services.EmpregadoService;
import EngSoftProjeto.dtos.EmpregadoCreateDTO;
import EngSoftProjeto.dtos.EmpregadoResponseDTO;
import EngSoftProjeto.dtos.TarefaCreateDTO;
import EngSoftProjeto.dtos.conversores.ConverterEmpregadoParaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("/empregado")
public class EmpregadoController {


    private final EmpregadoService empregadoService;
    private final ConverterEmpregadoParaDTO converterEmpregadoParaDTO= new ConverterEmpregadoParaDTO();

    public EmpregadoController(EmpregadoService empregadoService) {
        this.empregadoService = empregadoService;
    }





    //ENDPOINTS
    @PostMapping
    public ResponseEntity<EmpregadoResponseDTO> criarEmpregado(@RequestBody EmpregadoCreateDTO empregado){
        Optional<Empregado> optionalEmpregado=empregadoService.criaEmpregado(empregado.converter());
        return optionalEmpregado.map(value-> ResponseEntity.ok(converterEmpregadoParaDTO.converter(value))).orElseGet(()->ResponseEntity.badRequest().build());
    }

    @PatchMapping("/{empregadoId}/addTarefaEmpregado")
    public ResponseEntity<EmpregadoResponseDTO> adicionaTarefa(@PathVariable Long empregadoId, @RequestBody TarefaCreateDTO tarefa) {
        Optional<Empregado> optionalEmpregado= empregadoService.adicionaTarefa(empregadoId, tarefa.converter());
        return optionalEmpregado.map(empregado-> ResponseEntity.ok(converterEmpregadoParaDTO.converter(empregado))).orElseGet(() -> ResponseEntity.badRequest().build());
    }


}


