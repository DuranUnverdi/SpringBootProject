package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.IDepartmentEmployeeController;
import com.spring_rest_api.dto.DtoEmployee;
import com.spring_rest_api.services.impl.DepartmentEmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/employee/department")
public class DepartmentEmployeeControllerImpl implements IDepartmentEmployeeController {
    @Autowired
    private DepartmentEmployeeServiceImpl departmentEmployeeService;

    @Override
    @PostMapping("/save-employee")
    public DtoEmployee saveEmployee(@RequestBody DtoEmployee dtoEmployee) {
        return departmentEmployeeService.saveEmployee(dtoEmployee);
    }


}
