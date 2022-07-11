package com.example.demo.repository;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value= "SELECT * FROM contract where start_date like :contractStartDate and end_date like :contractEndDate",
            countQuery ="SELECT * FROM contract where start_date like :contractStartDate and end_date like :contractEndDate",nativeQuery =true)
    Page<Contract> search(@Param("contractStartDate")String contractStartDateSearch, @Param("contractEndDate") String contractEndDateSearch, Pageable pageable);
}
