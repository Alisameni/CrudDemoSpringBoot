package com.example.crudDemo;

import com.example.crudDemo.dao.StudentDAO;
import com.example.crudDemo.dao.StudentDAOImpl;
import com.example.crudDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoSpringBoot.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //for call each of methods uncomment it and comments another methods

            //this method save a student
            ///createStudent(studentDAO);

            //this method show a student by use from findById
            ///readStudent(studentDAO);

            //this method return list of all students
            ///queryForStudents(studentDAO);

            //this method return list of students find by lastName
            ///getStudentsByLastName(studentDAO);

            //this method update  students data
            ///updateStudents(studentDAO);

            //this method delete a student by id
            ///deleteStudent(studentDAO);

            //this method delete all of students
            delateAllStudents(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student student = new Student("Ali", "Sameni", "Ali@gmail.com");
        studentDAO.save(student);
        System.out.println("Student added: " + student.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = new Student("Ali", "Sameni", "Ali@gmail.com");
        studentDAO.save(student);
        int id = student.getId();
        System.out.println("Student added: " + id);
        Student readStudent = studentDAO.findById(id);
        System.out.println("Student read: " + readStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void getStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Sameni");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudents(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Getting student By id: " + studentId);
        Student student = studentDAO.findById(studentId);
        System.out.println("Student updated ...");
        student.setFirstName("Hassan");
        studentDAO.update(student);
        System.out.println("update Student:" + student);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 1;
        System.out.println("Deleting student By id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void delateAllStudents(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int rowsDeleted = studentDAO.deleteAll();
        System.out.println("Deleted rows count : " + rowsDeleted);
    }
}
