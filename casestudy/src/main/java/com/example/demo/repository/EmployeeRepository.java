package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value="SELECT * FROM employee where `name` like :nameSearch and `position_id` like :positionId " +
            "and `education_degree_id` like :educationDegreeId and `division_id` like :divisionId",
            countQuery ="SELECT * FROM employee where `name` like :nameSearch and `position_id` like :positionId " +
                    "and `education_degree_id` like :educationDegreeId and `division_id` like :divisionId",nativeQuery =true)
    Page<Employee> search(@Param("nameSearch")String employeeNameSearch, @Param("positionId") String positionIdSearch,
            @Param("educationDegreeId")String educationDegreeIdSearch, @Param("divisionId")String divisionIdSearch, Pageable pageable);
}
