package repository;

import java.util.List;

public interface TarefaRepository {
    List<Tarefa> findAll();
    Tarefa findById(Long id);
    Tarefa save(Tarefa task);
}

