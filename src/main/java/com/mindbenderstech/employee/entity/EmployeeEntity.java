package com.mindbenderstech.employee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee", schema = "dbo")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or another suitable strategy
    @Column(name="employee_id")
    private Integer employeeId;
    @Column(name="employee_name")
    private String employeeName;
    @Column(name="employee_email_id")
    private String employeeEmailId;
    @Column(name="employee_mob_no")
    private BigInteger employeeMobNo;
    @Column(name="employee_address")
    private String employeeAddress;
}
