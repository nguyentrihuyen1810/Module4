package com.example.demo.service.impl;

import com.example.demo.model.Customer_type;
import com.example.demo.repository.CustomerTypeRepository;
import com.example.demo.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeImpl implements ICustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<Customer_type> findAll() {
        return customerTypeRepository.findAll();
    }
}
