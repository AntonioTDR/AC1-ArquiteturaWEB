package main.java.service;

import org.springframework.stereotype.Service;
import java.util.List;
import main.java.ac1.arquiteturaweb.demo.model.Student;
import main.java.ac1.arquiteturaweb.demo.repository.StudentRepository;

public class ServiceIML {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

}
