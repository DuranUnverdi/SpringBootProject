package com.spring_rest_api.controller.impl;

import com.spring_rest_api.controller.BaseController;
import com.spring_rest_api.controller.ICustomerController;
import com.spring_rest_api.dto.DtoCustomer;
import com.spring_rest_api.entities.RootEntity;
import com.spring_rest_api.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/customers")
public class CustomerControllerImpl extends BaseController implements ICustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/list/{id}")
    @Override
    public RootEntity<DtoCustomer> findCustomerById(@PathVariable(name = "id") Long id) {
        return ok(customerService.findCustomerById(id));
    }

    @GetMapping("/list")
    @Override
    public RootEntity<List<DtoCustomer>> getAllCustomers() {
        return ok(customerService.getAllCustomers());
    }

    @PostMapping("/save")
    @Override
    public DtoCustomer saveCustomer(@RequestBody DtoCustomer dtoCustomer) {
        return customerService.saveCustomer(dtoCustomer);
    }
}
