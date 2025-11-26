package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.IStudentController;
import com.spring_rest_api.entities.Student;
import com.spring_rest_api.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/students")
public class StudentControllerImpl implements IStudentController {
    @Autowired
    private IStudentService studentService;
    @PostMapping("/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
}
