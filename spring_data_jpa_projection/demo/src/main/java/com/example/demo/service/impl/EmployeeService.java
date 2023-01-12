package com.example.demo.service.impl;

import com.example.demo.dto.EmployeeInfo;
import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<EmployeeInfo> findByCodeEmployeeContaining(String code, Pageable pageable) {
        return employeeRepository.findByCodeEmployeeContaining(code, pageable);
    }
}
