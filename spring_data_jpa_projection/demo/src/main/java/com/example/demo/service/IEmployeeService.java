package com.example.demo.service;

import com.example.demo.dto.EmployeeInfo;
import com.example.demo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Page<EmployeeInfo> findByCodeEmployeeContaining(String code, Pageable pageable);
}
