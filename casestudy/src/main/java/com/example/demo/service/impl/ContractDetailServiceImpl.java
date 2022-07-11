package com.example.demo.service.impl;

import com.example.demo.model.Contract_detail;
import com.example.demo.repository.ContractDetailRepository;
import com.example.demo.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private ContractDetailRepository contractDetailRepository;
    @Override
    public Page<Contract_detail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public Page<Contract_detail> findByAll(Pageable pageable, String contractDetailIdSearch, String contractDetailQuantitySearch) {
        return contractDetailRepository.search("%" + contractDetailIdSearch + "%", "%" + contractDetailQuantitySearch + "%", pageable);
    }

    @Override
    public void save(Contract_detail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public Optional<Contract_detail> findById(int id) {
        return contractDetailRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        contractDetailRepository.deleteById(id);
    }
}
