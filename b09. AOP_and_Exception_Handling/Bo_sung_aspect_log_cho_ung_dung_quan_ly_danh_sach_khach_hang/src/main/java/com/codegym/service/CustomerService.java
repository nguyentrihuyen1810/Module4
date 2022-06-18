package com.codegym.service;

import com.codegym.exception.MyException;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public class CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageInfo) throws Exception;

    List<Customer> search(String keyword);

    Page<Customer> search(String keyword, Pageable pageInfo);

    Customer findOne(Long id) throws MyException;

    Customer save(Customer customer);

    List<Customer> save(List<Customer> customers);

    boolean exists(Long id);

    List<Customer> findAll(List<Long> ids);

    long count();

    void delete(Long id);

    void delete(Customer customer);

    void delete(List<Customer> customers);

    void deleteAll();
}
