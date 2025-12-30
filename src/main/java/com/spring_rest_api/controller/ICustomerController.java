package com.spring_rest_api.controller;

import com.spring_rest_api.dto.DtoCustomer;
import com.spring_rest_api.entities.RootEntity;

public interface ICustomerController {
    public RootEntity<DtoCustomer> findCustomerById(Long id);
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer);


}
