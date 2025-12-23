package com.spring_rest_api.services.impl;

import com.spring_rest_api.dto.DtoDepartment;
import com.spring_rest_api.dto.DtoEmployee;
import com.spring_rest_api.entities.Department;
import com.spring_rest_api.entities.Employee;
import com.spring_rest_api.repository.DepartmentRepository;
import com.spring_rest_api.repository.EmployeeRepository;
import com.spring_rest_api.services.IDepartmentEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentEmployeeServiceImpl implements IDepartmentEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DtoEmployee saveEmployee(DtoEmployee dtoEmployee) {

        Employee employee = new Employee();
        employee.setName(dtoEmployee.getName());

        if (dtoEmployee.getDepartment() == null
                || dtoEmployee.getDepartment().getId() == null) {
            throw new RuntimeException("Department id zorunludur");
        }

        Department department = departmentRepository
                .findById(dtoEmployee.getDepartment().getId())
                .orElseThrow(() ->
                        new RuntimeException("Department bulunamadı")
                );

        employee.setDepartment(department);

        Employee savedEmployee = employeeRepository.save(employee);

        DtoEmployee result = new DtoEmployee();
        BeanUtils.copyProperties(savedEmployee, result);

        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(department, dtoDepartment);
        result.setDepartment(dtoDepartment);

        return result;
    }
}
