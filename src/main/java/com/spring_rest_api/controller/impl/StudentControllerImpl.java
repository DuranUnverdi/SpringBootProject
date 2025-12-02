package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.IStudentController;
import com.spring_rest_api.dto.DtoStudent;
import com.spring_rest_api.dto.DtoStudentIU;
import com.spring_rest_api.entities.Student;
import com.spring_rest_api.services.IStudentService;
import jakarta.validation.Valid;
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
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU studentIU) {
        return studentService.saveStudent(studentIU);
    }

    @GetMapping("/list")
    @Override
    public List<DtoStudent> getAllStudents() {

        return studentService.getAllStudents();
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoStudent updateStudent(@PathVariable(name = "id") Integer id, @RequestBody DtoStudentIU student) {
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/list/{id}")
    @Override
    public DtoStudent listStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public DtoStudent deleteStudentById(@PathVariable(name = "id") Integer id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/firstname/{firstName}")
    @Override
    public DtoStudent getStudentByFirstName(@PathVariable(name ="firstName" ) String firstName) {
        return studentService.getStudentByFirstName(firstName);
    }


}
