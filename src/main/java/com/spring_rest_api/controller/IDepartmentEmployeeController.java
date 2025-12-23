package com.spring_rest_api.controller;

import com.spring_rest_api.dto.DtoEmployee;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface IDepartmentEmployeeController {
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);
    public List<DtoEmployee> getAllEmployees();
    public DtoEmployee getEmployeeById(Long id);

}
