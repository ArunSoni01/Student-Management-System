package com.sms.repository;

import com.sms.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void add(Student student);
    List<Student> findAll();
    Optional<Student> findById(int id);
    boolean update(Student student);
    boolean delete(int id);
}
