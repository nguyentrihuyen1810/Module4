package com.example.demo.service;

import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IServiceService {
    Page<Service> findAll(Pageable pageable);

    Page<Service> findByAll(Pageable pageable, String serviceNameSearch, String serviceTypeIdSearch);

    void save(Service service);

    Optional<Service> findById(int id);

    void delete (int id);
}
