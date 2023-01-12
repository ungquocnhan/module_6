package com.example.demo.repository;

import com.example.demo.dto.EmployeeInfo;
import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findAll(Pageable pageable);

    Page<EmployeeInfo> findByCodeEmployeeContaining(String code, Pageable pageable);
}
