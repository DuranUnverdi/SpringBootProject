package com.spring_rest_api.services.impl;

import com.spring_rest_api.dto.DtoStudent;
import com.spring_rest_api.dto.DtoStudentIU;
import com.spring_rest_api.entities.Student;
import com.spring_rest_api.repository.StudentRepository;
import com.spring_rest_api.services.IStudentService;
import com.spring_rest_api.utils.CryptoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU studentIU) {
        try {
            // IdentityNumber şifrele
            String encryptedIdentity = CryptoUtils.encrypt(studentIU.getIdentityNumber());
            studentIU.setIdentityNumber(encryptedIdentity);
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting identity number", e);
        }

        // DTO → Entity
        Student student = new Student();
        BeanUtils.copyProperties(studentIU, student);

        // Kaydet
        Student savedStudent = studentRepository.save(student);

        // Entity → DTO
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(savedStudent, dtoStudent);


        return dtoStudent;
    }


    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoStudents = studentRepository.findAll().stream().map(student -> {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            return dtoStudent;
        }).toList();
        return dtoStudents;
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU student) {
        DtoStudent dtoStudent = new DtoStudent();
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            BeanUtils.copyProperties(student, existingStudent);
            Student updatedStudent = studentRepository.save(existingStudent);
            BeanUtils.copyProperties(updatedStudent, dtoStudent);
        }
        return dtoStudent;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dtoStudent = new DtoStudent();
        Student student = studentRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(student, dtoStudent);
        return dtoStudent;
    }

    @Override
    public DtoStudent deleteStudentById(Integer id) {
        DtoStudent dtoStudent = new DtoStudent();
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            BeanUtils.copyProperties(student, dtoStudent);
            studentRepository.deleteById(id);
        }
        return dtoStudent;

    }

    @Override
    public DtoStudent getStudentByFirstName(String firstName) {
        DtoStudent dto = new DtoStudent();
        Student student = studentRepository.findByFirstName(firstName);
        if (student != null) {
            BeanUtils.copyProperties(student, dto);
        }
        return dto;
    }


}
