package main.java.repository;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findById(Long id);
    Student save(Student student);
}