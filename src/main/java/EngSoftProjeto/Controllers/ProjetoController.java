package engsoftprojeto.controllers;

import engsoftprojeto.models.Projeto;
import engsoftprojeto.services.ProjetoService;
import engsoftprojeto.dtos.*;
import engsoftprojeto.dtos.conversores.ConverterCustoProjetoDTO;
import engsoftprojeto.dtos.conversores.ConverterDuracaoProjetoDTO;
import engsoftprojeto.dtos.conversores.ConverterProjetoParaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService projetoService;
    private final ConverterProjetoParaDTO converterProjetoParaDTO= new ConverterProjetoParaDTO();
    private final ConverterDuracaoProjetoDTO converterDuracaoProjetoDTO= new ConverterDuracaoProjetoDTO();
    private final ConverterCustoProjetoDTO converterCustoProjetoDTO= new ConverterCustoProjetoDTO();

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    //ENDPOINTS
    @GetMapping("/findAll")
    public ResponseEntity<Iterable<ProjetoResponseDTO>> getAllProjetos(){
        List<ProjetoResponseDTO> responseDTOS= new ArrayList<>();
        projetoService.findAll().forEach(projeto -> responseDTOS.add(converterProjetoParaDTO.converter(projeto)));
        return ResponseEntity.ok(responseDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> getProjetoById(@PathVariable Long id){
        Optional<Projeto> optionalProjeto= projetoService.findById(id);
        return optionalProjeto.map(projeto -> {
            ProjetoResponseDTO projetoResponseDTO= converterProjetoParaDTO.converter(projeto);
            return ResponseEntity.ok(projetoResponseDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> createProjeto(@RequestBody ProjetoCreateDTO projeto){
        Optional<Projeto> optionalProjeto= projetoService.criarProjeto(projeto.converter());
        return optionalProjeto.map(value-> ResponseEntity.ok(converterProjetoParaDTO.converter(value))).orElseGet(
                ()-> ResponseEntity.badRequest().build());
    }


    @GetMapping("/custo/{id}")
    public ResponseEntity<ProjetoResponseDTO> getCustoProjeto(@PathVariable Long id){
        Optional<Projeto> optionalProjeto=projetoService.custoProjeto(id);
        return optionalProjeto.map(projetoCusto -> {
            ProjetoResponseDTO projetoResponseDTO= converterCustoProjetoDTO.converter(projetoCusto);
            return ResponseEntity.ok(projetoResponseDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/duracao/{id}")
    public ResponseEntity<ProjetoResponseDTO> getDuracaoProjeto(@PathVariable Long id){
        Optional<Projeto> optionalProjeto=projetoService.duracaoProjeto(id);
        return optionalProjeto.map(projetoDuracao -> {
            ProjetoResponseDTO projetoResponseDTO= converterDuracaoProjetoDTO.converter(projetoDuracao);
            return ResponseEntity.ok(projetoResponseDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PatchMapping("/{projetoId}/addTarefaProjeto")
    public ResponseEntity<ProjetoResponseDTO> adicionaTarefa(@PathVariable Long projetoId, @RequestBody TarefaCreateDTO tarefa){
        Optional<Projeto> optionalProjeto= projetoService.adicionaTarefa(projetoId,tarefa.converter());
        return optionalProjeto.map(projeto -> ResponseEntity.ok(converterProjetoParaDTO.converter(projeto))).orElseGet(() -> ResponseEntity.badRequest().build());
    }


}



