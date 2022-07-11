package com.example.demo.service;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByAll(Pageable pageable, String customerNameSearch, String customerTypeIdSearch);

    void save(Customer customer);

    Optional<Customer> findById(int id);

    void delete (int id);
}
