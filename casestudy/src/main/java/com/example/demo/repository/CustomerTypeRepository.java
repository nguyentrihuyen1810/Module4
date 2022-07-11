package com.example.demo.repository;

import com.example.demo.model.Customer_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<Customer_type, Integer> {
}
