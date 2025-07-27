package com.sms.service;

import com.sms.model.Student;
import com.sms.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void addStudent(Student student) {
        repo.add(student);
        System.out.println("Student added successfully.");
    }

    public void listStudents() {
        List<Student> students = repo.findAll();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    public void updateStudent(Student student) {
        boolean updated = repo.update(student);
        System.out.println(updated ? "Student updated." : "Student not found.");
    }

    public void deleteStudent(int id) {
        boolean deleted = repo.delete(id);
        System.out.println(deleted ? "Student deleted." : "Student not found.");
    }

    public void findStudentById(int id) {
        Optional<Student> student = repo.findById(id);
        student.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Student not found.")
        );
    }
}
