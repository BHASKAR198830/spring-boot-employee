package com.mindbenderstech.employee.controller;

import com.mindbenderstech.employee.dto.Request;
import com.mindbenderstech.employee.dto.Response;
import com.mindbenderstech.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/save")
    public Response saveEmployee(@RequestBody Request request) {
        return employeeService.saveEmployee(request);
    }

    @GetMapping("/get")
    public Response getEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get/{employeeId}")
    public Response getEmployeeById(@PathVariable int employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/update/{employeeId}")
    public Response updateEmployeeById(@PathVariable int employeeId, @RequestBody Request request) {
        return employeeService.updateEmployeeById(employeeId, request);
    }


}
