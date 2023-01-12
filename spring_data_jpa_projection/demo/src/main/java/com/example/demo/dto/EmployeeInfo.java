package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Value;

/**
 * A Projection for the {@link com.example.demo.model.Employee} entity
 */
public interface EmployeeInfo {
    //    Close projection
    long getId();

    String getCodeEmployee();

    String getDateOfBirth();

    String getPhoneEmployee();

    String getEmailEmployee();

    String getAddress();

    DivisionInfo getDivision();

    //    Open projection
//    @Value("#{target.id.toString() + ' ' + target.codeEmployee}")
//    String getCodeId();
//
//    @Value("#{'NV-'+target.id.toString()}")
//    String getEmployeeId();
}