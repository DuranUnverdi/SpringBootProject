package com.spring_rest_api.services;

import com.spring_rest_api.dto.DtoCustomer;

import java.util.List;

public interface ICustomerService {
    public DtoCustomer findCustomerById(Long id);

    List<DtoCustomer> getAllCustomers();

    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer);
}
