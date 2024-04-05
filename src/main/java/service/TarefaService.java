package service;

import java.util.List;

import model.Tarefa;

public interface TarefaService {
    List<Tarefa> getAllTarefa();
    Tarefa getTarefaById(Long id);
    Tarefa createTarefa(Tarefa tarefa);
}



