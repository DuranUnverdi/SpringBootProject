package com.spring_rest_api.services;

import com.spring_rest_api.dto.DtoCustomer;

public interface ICustomerService {
    public DtoCustomer findCustomerById(Long id);
}
