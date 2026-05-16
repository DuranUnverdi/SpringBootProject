package com.spring_rest_api.controller;

import com.spring_rest_api.dto.DtoCustomer;
import com.spring_rest_api.entities.RootEntity;

import java.util.List;

public interface ICustomerController {
    public RootEntity<DtoCustomer> findCustomerById(Long id);

    RootEntity<List<DtoCustomer>> getAllCustomers();

    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer);

    RootEntity<DtoCustomer> updateCustomer(Long id, DtoCustomer dtoCustomer);

}
