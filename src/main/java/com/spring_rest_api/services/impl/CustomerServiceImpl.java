package com.spring_rest_api.services.impl;

import com.spring_rest_api.dto.DtoAdress;
import com.spring_rest_api.dto.DtoCustomer;
import com.spring_rest_api.entities.Adress;
import com.spring_rest_api.entities.Customer;
import com.spring_rest_api.repository.CustomerRepository;
import com.spring_rest_api.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public DtoCustomer findCustomerById(Long id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found with id: " + id));

        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAdress dtoAdress = new DtoAdress();

        BeanUtils.copyProperties(customer, dtoCustomer);

        if (customer.getAdress() != null) {
            BeanUtils.copyProperties(customer.getAdress(), dtoAdress);
            dtoCustomer.setAdress(dtoAdress);
        }

        return dtoCustomer;
    }

    @Override
    public List<DtoCustomer> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> {
                    DtoCustomer dtoCustomer = new DtoCustomer();
                    DtoAdress dtoAdress = new DtoAdress();
                    BeanUtils.copyProperties(customer, dtoCustomer);
                    if (customer.getAdress() != null) {
                        BeanUtils.copyProperties(customer.getAdress(), dtoAdress);
                        dtoCustomer.setAdress(dtoAdress);
                    }
                    return dtoCustomer;
                })
                .toList();
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomer dtoCustomer) {

        Customer customer = new Customer();
        Adress adress = new Adress();

        // Customer bilgilerini aktar
        customer.setName(dtoCustomer.getName());

        // Adres bilgileri doluysa aktar
        if (dtoCustomer.getAdress() != null) {
            BeanUtils.copyProperties(dtoCustomer.getAdress(), adress);
            customer.setAdress(adress);
            adress.setCustomer(customer); // OneToOne çift yön ilişki
        }

        // Kaydet
        Customer saved = customerRepository.save(customer);

        // DTO döndür
        DtoCustomer result = new DtoCustomer();
        DtoAdress resultAdress = new DtoAdress();

        BeanUtils.copyProperties(saved, result);

        if (saved.getAdress() != null) {
            BeanUtils.copyProperties(saved.getAdress(), resultAdress);
            result.setAdress(resultAdress);
        }

        return result;
    }


}
