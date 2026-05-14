package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.IDepartmentEmployeeController;
import com.spring_rest_api.dto.DtoEmployee;
import com.spring_rest_api.services.IDepartmentEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee/department")
public class DepartmentEmployeeControllerImpl implements IDepartmentEmployeeController {
    @Autowired
    private IDepartmentEmployeeService departmentEmployeeService;

    @Override
    @PostMapping("/save-employee")
    public DtoEmployee saveEmployee(@RequestBody DtoEmployee dtoEmployee) {
        return departmentEmployeeService.saveEmployee(dtoEmployee);
    }

    @Override
    @GetMapping("/get-employee")
    public List<DtoEmployee> getAllEmployees() {
        return departmentEmployeeService.getAllEmployees();
    }

    @Override
    @GetMapping("/get-employee/{id}")
    public DtoEmployee getEmployeeById(@PathVariable (name = "id") Long id) {
        return departmentEmployeeService.getEmployeeById(id);
    }


}
