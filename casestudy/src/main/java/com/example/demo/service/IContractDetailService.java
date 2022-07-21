package com.example.demo.service;

import com.example.demo.model.Contract_detail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractDetailService {
    Page<Contract_detail> findAll(Pageable pageable);

    Page<Contract_detail> findByAll(Pageable pageable, String contractIdSearch, String contractDetailQuantitySearch);

    void save(Contract_detail contractDetail);

    Optional<Contract_detail> findById(int id);

    void delete (int id);
}
