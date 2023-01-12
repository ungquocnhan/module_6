package com.example.demo.controller;

import com.example.demo.dto.EmployeeInfo;
import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    // Get All property
    @GetMapping("")
    public ResponseEntity<Page<Employee>> getAll(@PageableDefault(size = 5) Pageable pageable){
        Page<Employee> employeePage = employeeService.findAll(pageable);
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    // Get Spring JPA projection
//    @GetMapping("")
//    public ResponseEntity<Page<EmployeeInfo>> getAll(@RequestParam(defaultValue = "") String code, @PageableDefault(size = 5) Pageable pageable){
//        Page<EmployeeInfo> employeePage = employeeService.findByCodeEmployeeContaining(code, pageable);
//        return new ResponseEntity<>(employeePage, HttpStatus.OK);
//    }
}
