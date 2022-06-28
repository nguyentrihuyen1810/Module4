package com.example.demo.repository;

import com.example.demo.model.Smartphone;
import org.springframework.data.repository.CrudRepository;

public interface ISmartphoneRepository extends CrudRepository <Smartphone, Long> {
}
