package com.codegym.service.impl;

import com.codegym.exception.MyException;
import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import java.util.List;

import java.awt.print.Pageable;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return streamAll().collect(Collectors.toList());
    }

    @Override
    public Page<Customer> findAll(Pageable pageInfo) throws Exception {
//        if (true) throw new Exception("a dummy exception");
        return customerRepository.findAll(pageInfo);
    }

    @Override
    public List<Customer> search(String keyword) {
        Iterable<Customer> searchResult = customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword);
        return streamAll(searchResult).collect(Collectors.toList());
    }

    @Override
    public Page<Customer> search(String keyword, Pageable pageInfo) {
        return customerRepository
                .findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword, pageInfo);
    }

    @Override
    public Customer findOne(Long id) throws MyException {
        Customer target = customerRepository.findOne(id);
        if (target == null) {
            throw new MyException();
        }
        return target;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> save(List<Customer> customers) {
        Iterable<Customer> updatedCustomers = customerRepository.save(customers);
        return streamAll(updatedCustomers).collect(Collectors.toList());
    }

    @Override
    public boolean exists(Long id) {
        return customerRepository.exists(id);
    }

    @Override
    public List<Customer> findAll(List<Long> ids) {
        Iterable<Customer> customers = customerRepository.findAll(ids);
        return streamAll(customers).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return customerRepository.count();
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void delete(List<Customer> customers) {
        customerRepository.delete(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    private Stream<Customer> streamAll() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false);
    }

    private Stream<Customer> streamAll(Iterable<Customer> customers) {
        return StreamSupport.stream(customers.spliterator(), false);
    }
}
