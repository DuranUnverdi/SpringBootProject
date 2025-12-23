package com.spring_rest_api.services;

import com.spring_rest_api.dto.DtoEmployee;

import java.util.List;

public interface IDepartmentEmployeeService {
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee);
    public List<DtoEmployee> getAllEmployees();
    public DtoEmployee getEmployeeById(Long id);

}
