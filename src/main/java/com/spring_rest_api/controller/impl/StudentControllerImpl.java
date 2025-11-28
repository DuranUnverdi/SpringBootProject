package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.IStudentController;
import com.spring_rest_api.entities.Student;
import com.spring_rest_api.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all/list")
    @Override
    public List<Student> getAllStudents() {

        return studentService.getAllStudents();
    }
    @PutMapping("/update/{id}")
    @Override
    public Student updateStudent(@PathVariable(name ="id") Integer id,@RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }


}
