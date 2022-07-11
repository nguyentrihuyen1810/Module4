package com.example.demo.service.impl;

import com.example.demo.model.Rent_type;
import com.example.demo.repository.RentTypeRepository;
import com.example.demo.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public List<Rent_type> findAll() {
        return rentTypeRepository.findAll();
    }
}
