package com.example.crudDemo.dao;

import com.example.crudDemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String LastName);
    void update(Student student);
    void delete(int id);
    int deleteAll();
}
