package com.example.demo.service;

import com.example.demo.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findByAll(Pageable pageable, String contractStartDateSearch, String contractEndDateSearch);

    void save(Contract contract);

    Optional<Contract> findById(int id);

    void delete (int id);
}
