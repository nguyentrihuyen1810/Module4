package com.example.demo.repository;

import com.example.demo.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    @Query(value="SELECT * FROM service where `name` like :nameSearch and service_type_id like :serviceTypeId",
            countQuery ="SELECT * FROM service where `name` like :nameSearch and service_type_id like :serviceTypeId",nativeQuery =true)
    Page<Service> search(@Param("nameSearch")String serviceNameSearch, @Param("serviceTypeId") String serviceTypeIdSearch, Pageable pageable);
}
