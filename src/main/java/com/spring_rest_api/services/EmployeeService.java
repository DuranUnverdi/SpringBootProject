package com.spring_rest_api.services;

import com.spring_rest_api.model.Employee;
import com.spring_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
     return employeeRepository.getAllEmployees();
    }
    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }
}
