package com.spring_rest_api.repository;

import com.spring_rest_api.dto.DtoCustomer;
import com.spring_rest_api.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public DtoCustomer findCustomerById(Long id);


}
