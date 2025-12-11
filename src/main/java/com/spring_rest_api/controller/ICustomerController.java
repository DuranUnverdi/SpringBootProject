package com.spring_rest_api.controller;

import com.spring_rest_api.dto.DtoCustomer;

public interface ICustomerController {
    public DtoCustomer findCustomerById(Long id);
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer);


}
