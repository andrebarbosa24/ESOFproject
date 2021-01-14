package EngSoftProjeto.Controllers;

import EngSoftProjeto.Models.Tarefa;
import EngSoftProjeto.Services.TarefaService;
import EngSoftProjeto.dtos.TarefaCreateDTO;
import EngSoftProjeto.dtos.TarefaResponseDTO;
import EngSoftProjeto.dtos.conversores.ConverterTarefaParaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;
    private final ConverterTarefaParaDTO converterTarefaParaDTO= new ConverterTarefaParaDTO();

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    //ENDPOINTS
    @PostMapping
    public ResponseEntity<TarefaResponseDTO> criarTarefa(@RequestBody TarefaCreateDTO tarefa){
        Optional<Tarefa> optionalTarefa= this.tarefaService.criarTarefa(tarefa.converter());
        return optionalTarefa.map(value -> ResponseEntity.ok(converterTarefaParaDTO.converter(value))).orElseGet(() -> ResponseEntity.badRequest().build());
    }



}
