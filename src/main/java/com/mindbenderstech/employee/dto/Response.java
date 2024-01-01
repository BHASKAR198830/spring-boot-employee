package com.mindbenderstech.employee.dto;

import com.mindbenderstech.employee.entity.EmployeeEntity;
import lombok.Data;

import java.util.List;

@Data
public class Response {
    private String message;
    private String statusCode;
    private List<EmployeeEntity> lstEmployee;
}
