package com.spring_rest_api.controller;

import com.spring_rest_api.entities.Student;

import java.util.List;

public interface IStudentController {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student updateStudent(Integer id, Student student);
    public Student listStudentById(Integer id);
}
