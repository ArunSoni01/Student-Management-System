package com.sms;

import com.sms.config.DBConnection;
import com.sms.model.Student;
import com.sms.repository.StudentRepositoryImpl;
import com.sms.service.StudentService;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO STUDENT MANAGEMENT SYSTEM");

        try (Connection conn = DBConnection.getConnection();
             Scanner scanner = new Scanner(System.in)) {

            StudentService service = new StudentService(new StudentRepositoryImpl(conn));

            while (true) {
                System.out.println("\n1. Add student\n2. View all\n3. Update\n4. Delete\n5. Find by ID\n6. Exit");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> service.addStudent(getStudentInput(scanner, false));
                    case 2 -> service.listStudents();
                    case 3 -> service.updateStudent(getStudentInput(scanner, true));
                    case 4 -> {
                        System.out.print("Enter ID to delete: ");
                        service.deleteStudent(scanner.nextInt());
                    }
                    case 5 -> {
                        System.out.print("Enter ID to find: ");
                        service.findStudentById(scanner.nextInt());
                    }
                    case 6 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static Student getStudentInput(Scanner scanner, boolean isUpdate) {
        int id = 0;
        if (isUpdate) {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
        }

        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter email: ");
        String email = scanner.next();

        return isUpdate ? new Student(id, name, age, email) : new Student(name, age, email);
    }
}
