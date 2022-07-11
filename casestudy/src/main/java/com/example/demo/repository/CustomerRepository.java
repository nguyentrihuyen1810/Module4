package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value="SELECT * FROM customer where `name` like :nameSearch and customer_type_id like :customerTypeId",
            countQuery ="SELECT * FROM customer where `name` like :nameSearch and customer_type_id like :customerTypeId",nativeQuery =true)
    Page<Customer> search(@Param("nameSearch")String customerNameSearch, @Param("customerTypeId") String customerTypeIdSearch, Pageable pageable);
}
