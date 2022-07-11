package com.example.demo.service.impl;

import com.example.demo.model.Attach_service;
import com.example.demo.repository.AttachServiceRepository;
import com.example.demo.service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements IAttachService {
    @Autowired
    AttachServiceRepository attachServiceRepository;

    @Override
    public List<Attach_service> findAll() {
        return attachServiceRepository.findAll();
    }
}
