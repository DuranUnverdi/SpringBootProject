package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.ICustomerController;
import com.spring_rest_api.dto.DtoCustomer;
import com.spring_rest_api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customers")
public class CustomerControllerImpl implements ICustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/list/{id}")
    @Override
    public DtoCustomer findCustomerById(@PathVariable(name = "id") Long id) {
        return customerService.findCustomerById(id);
    }
}
