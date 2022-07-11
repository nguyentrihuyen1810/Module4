package com.example.demo.service.impl;

import com.example.demo.model.Education_degree;
import com.example.demo.repository.EducationDegreeRepository;
import com.example.demo.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements IEducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<Education_degree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
