package main.java.ac1.arquiteturaweb.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/students")

public class StudentController {

    private Map<Integer, Student> studentsMap = new HashMap<>();

    public StudentController() {
        studentsMap.put(1, new Student(1, "AlunoA", "Zagueiro"));
        studentsMap.put(2, new Student(2, "AlunoB", "Lugano"));
        studentsMap.put(3, new Student(3, "AlunoC", "Arboleda"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return new ArrayList<>(studentsMap.values());
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentsMap.getOrDefault(id, new Student(-1, "Aluno Inválido"));
    }

    @PostMapping("/students")
    public void createStudent(@RequestBody Student student) {
        studentsMap.put(student.getId(), student);
        System.out.println("Aluno: " + student.getName() + " adicionado com sucesso!");
    }
}
