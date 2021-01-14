package engsoftprojeto.services;

import engsoftprojeto.models.Tarefa;


import java.util.Optional;

public interface TarefaService {

    Optional<Tarefa> criarTarefa(Tarefa tarefa);
}
