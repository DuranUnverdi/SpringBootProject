package com.spring_rest_api.repository;

import com.spring_rest_api.config.AppConfig;
import com.spring_rest_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> getEmployees;
    public List<Employee> getAllEmployees() {

        return getEmployees;
    }
}
