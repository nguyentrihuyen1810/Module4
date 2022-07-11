package com.example.demo.service.impl;

import com.example.demo.model.Contract;
import com.example.demo.repository.ContractRepository;
import com.example.demo.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findByAll(Pageable pageable, String contractStartDateSearch, String contractEndDateSearch) {
        return contractRepository.search("%" + contractStartDateSearch + "%", "%" + contractEndDateSearch + "%", pageable);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        contractRepository.deleteById(id);
    }
}
