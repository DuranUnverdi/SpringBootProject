package com.spring_rest_api.services;

import com.spring_rest_api.dto.DtoStudent;
import com.spring_rest_api.dto.DtoStudentIU;
import com.spring_rest_api.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU studentIU);
    public List<DtoStudent> getAllStudents();
    public DtoStudent updateStudent(Integer id, DtoStudentIU student);
    public DtoStudent getStudentById(Integer id);
    public DtoStudent deleteStudentById(Integer id);
    DtoStudent getStudentByFirstName(String firstName);

}
