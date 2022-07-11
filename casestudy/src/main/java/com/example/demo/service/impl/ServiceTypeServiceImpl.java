package com.example.demo.service.impl;

import com.example.demo.model.Service_type;
import com.example.demo.repository.ServiceTypeRepository;
import com.example.demo.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @Override
    public List<Service_type> findAll() {
        return serviceTypeRepository.findAll();
    }
}
