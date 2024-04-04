package main.java.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final List<Student> students = new ArrayList<>();
    private Long nextId = 1L;

    public StudentRepositoryImpl() {
        // Adiciona alguns alunos predefinidos ao iniciar
        students.add(new Student(nextId++, "Zagueiro", "Diniz", "Marinho Alves, 421", "525256251732", "Lol"));
        students.add(new Student(nextId++, "Lugano", "Mighuel", "Cicero Pompeu, 999", "987124653233", "Futebol"));
        students.add(new Student(nextId++, "Arboleda", "Robert", "Tropa do zaza, 666", "97513508416", "Balada"));
    }

    @Override
    public List<Student> findAll() {
        // Retorna todos os alunos
        return students;
    }

    @Override
    public Student findById(Long id) {
        // Procura pelo aluno com o ID especificado
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student; // Retorna o aluno se encontrado
            }
        }
        return null; // Retorna null se não encontrado
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == null) {
            // Se o aluno não tem um ID, atribui um novo ID a ele e o adiciona à lista de alunos
            student.setId(nextId++);
            students.add(student);
        } else {
            // Se o aluno já tem um ID, encontra-o na lista e substitui seus dados pelo novo aluno
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getId().equals(student.getId())) {
                    students.set(i, student);
                    break;
                }
            }
        }
        return student; // Retorna o aluno salvo
    }
}
