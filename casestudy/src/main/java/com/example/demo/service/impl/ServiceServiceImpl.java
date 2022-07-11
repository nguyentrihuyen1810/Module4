package com.example.demo.service.impl;

import com.example.demo.repository.ServiceRepository;
import com.example.demo.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Page<com.example.demo.model.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public Page<com.example.demo.model.Service> findByAll(Pageable pageable, String serviceNameSearch, String serviceTypeIdSearch) {
        return serviceRepository.search("%" + serviceNameSearch + "%", "%" + serviceTypeIdSearch + "%" , pageable);
    }

    @Override
    public void save(com.example.demo.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public Optional<com.example.demo.model.Service> findById(int id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }
}
