package com.example.demo.service;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByAll(Pageable pageable, String employeeNameSearch, String positionIdSearch);

    void save(Employee employee);

    Optional<Employee> findById(int id);

    void delete (int id);
}
