package com.spring_rest_api.repository;

import com.spring_rest_api.config.AppConfig;
import com.spring_rest_api.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private List<Employee> getEmployees;

    public List<Employee> getAllEmployees() {

        return getEmployees;
    }

    public Employee getEmployeeById(String id) {
        return getEmployees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> getEployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return getEmployees;
        }
        for (Employee emp : getEmployees) {
            if (firstName != null && lastName != null) {
                if (emp.getFirstName().equalsIgnoreCase(firstName) && emp.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(emp);
                }
            } else if (firstName != null) {
                if (emp.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeWithParams.add(emp);
                }
            } else if (lastName != null) {
                if (emp.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(emp);
                }
            }
        }
        return employeeWithParams;

    }
}

