package com.mindbenderstech.employee.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigInteger;

@Data
public class Request {

    private String employeeName;

    private String employeeEmailId;

    private BigInteger employeeMobNo;

    private String employeeAddress;
}
