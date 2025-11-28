package com.spring_rest_api.services;

import com.spring_rest_api.entities.Student;

import java.util.List;

public interface IStudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student updateStudent(Integer id, Student student);
    public Student getStudentById(Integer id);
    public Student deleteStudentById(Integer id);

}
