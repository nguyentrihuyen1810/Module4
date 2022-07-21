package com.example.demo.repository;

import com.example.demo.model.Contract_detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContractDetailRepository extends JpaRepository<Contract_detail, Integer> {
    @Query(value="SELECT * FROM contract_detail where contract_id like :contractId and quantity like :quantity",
            countQuery ="SELECT * FROM contract_detail where contract_id like :contractId and quantity like :quantity",nativeQuery =true)
    Page<Contract_detail> search(@Param("contractId")String contractIdSearch, @Param("quantity") String contractDetailQuantitySearch, Pageable pageable);
}
