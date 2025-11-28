package com.spring_rest_api.services.impl;

import com.spring_rest_api.entities.Student;
import com.spring_rest_api.repository.StudentRepository;
import com.spring_rest_api.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        return studentRepository.findById(id).map(existingStudent -> {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setBirthDate(student.getBirthDate());
            return studentRepository.save(existingStudent);
        }).orElseGet(() -> {
            student.setId(id);
            return studentRepository.save(student);
        });
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }


}
