package ac1.arquiteturaweb.demo.controller;

import service.TarefaService;
import model.Tarefa;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Tarefas")
public class TarefaController {
    private final TarefaService TarefaService;

    public TarefaController(TarefaService TarefaService) {
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
    public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
        return TarefaService.createTarefa(tarefa);
    }
}
