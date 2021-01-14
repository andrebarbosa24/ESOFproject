package EngSoftProjeto.Services;

import EngSoftProjeto.Models.Tarefa;


import java.util.Optional;

public interface TarefaService {

    Optional<Tarefa> criarTarefa(Tarefa tarefa);
}
