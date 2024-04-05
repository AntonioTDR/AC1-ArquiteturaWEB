package ac1.arquiteturaweb.demo.controller;

import model.Tarefa;
import service.TarefaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tarefas")
public class Controller {
    private final TarefaService TarefaService;

    public Controller(TarefaService TarefaService) {
        this.TarefaService = TarefaService;
    }

    @GetMapping
    public List<Tarefa> getAllTarefa() {
        return TarefaService.getAllTarefa();
    }

    @GetMapping("/{id}")
    public Tarefa getTarefaById(@PathVariable Long id) {
        return TarefaService.getTarefaById(id);
    }

    @PostMapping("/add")
    public Tarefa createTarefa(@RequestBody Tarefa Tarefa) {
        return TarefaService.createTarefa(Tarefa);
    }
}
