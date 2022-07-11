package com.example.demo.repository;

import com.example.demo.model.Rent_type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentTypeRepository extends JpaRepository<Rent_type, Integer> {
}
