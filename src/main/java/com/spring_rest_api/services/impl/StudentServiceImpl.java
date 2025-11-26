package com.spring_rest_api.services.impl;

import com.spring_rest_api.entities.Student;
import com.spring_rest_api.repository.StudentRepository;
import com.spring_rest_api.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }
}
