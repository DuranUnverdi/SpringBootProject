package com.spring_rest_api.controller;

import com.spring_rest_api.model.Employee;
import com.spring_rest_api.model.UpdateEmployeeRequest;
import com.spring_rest_api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/list/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id",required = true)String id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/list/params")
    public List<Employee> getEmployeeWithParams(@RequestParam(name = "firstName",required = false)String firstName,
                                                @RequestParam(name = "lastName",required = false)String lastName) {
        return employeeService.getEmployeeWithParams(firstName, lastName);
    }
    @PostMapping("/save-employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    @DeleteMapping("/delete-employee/{id}")
    public boolean deleteEmployee(@PathVariable(name="id") String id) {
    return employeeService.deleteEmployee(id);
    }
    @PutMapping("/update-employee/{id}")
    public Employee updateEmployee(@PathVariable(name= "id") String id,@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        return employeeService.updateEmployee(id,updateEmployeeRequest);
    }
}
