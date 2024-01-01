package com.mindbenderstech.employee.service;

import com.mindbenderstech.employee.dto.Request;
import com.mindbenderstech.employee.dto.Response;
import com.mindbenderstech.employee.entity.EmployeeEntity;
import com.mindbenderstech.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Response saveEmployee(Request request) {
        System.out.println(request);
        Response response = new Response();
        try {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setEmployeeName(request.getEmployeeName());
            employeeEntity.setEmployeeEmailId(request.getEmployeeEmailId());
            employeeEntity.setEmployeeMobNo(request.getEmployeeMobNo());
            employeeEntity.setEmployeeAddress(request.getEmployeeAddress());
            employeeRepository.save(employeeEntity);
            response.setMessage("Success");
            response.setStatusCode("200");
        } catch (Exception ex) {
            response.setMessage("Exception" + ex.getMessage());
            response.setStatusCode("200");
        }
        return response;
    }

    public Response getAllEmployee() {
        Response response = new Response();
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        try {
            employeeEntityList = employeeRepository.findAll();
            response.setMessage("Success");
            response.setStatusCode("200");
            response.setLstEmployee(employeeEntityList);
        } catch (Exception ex) {
            response.setMessage("Exception" + ex.getMessage());
            response.setStatusCode("200");
        }
        return response;
    }

    public Response getEmployeeById(int employeeId) {
        Response response = new Response();
        EmployeeEntity employeeEntity = new EmployeeEntity();
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        try {
            employeeEntity = employeeRepository.findById(employeeId).orElse(null);
//            if(empEntity.isEmpty()) {
//                employeeEntity = empEntity.get();
//                response.setLstEmployee(Collections.singletonList(employeeEntity));
//            }
            response.setMessage("Success");
            response.setStatusCode("200");
            response.setLstEmployee(Collections.singletonList(employeeEntity));

        } catch (Exception ex) {
            response.setMessage("Exception" + ex.getMessage());
            response.setStatusCode("200");
        }
        return response;
    }

    public Response updateEmployeeById(int employeeId, Request request) {
        Response response = new Response();
        try {
            Optional<EmployeeEntity> empData = employeeRepository.findById(employeeId);
            if (empData.isPresent()) {
                EmployeeEntity empEntity = empData.get();
                empEntity.setEmployeeName(request.getEmployeeName());
                empEntity.setEmployeeEmailId(request.getEmployeeEmailId());
                empEntity.setEmployeeMobNo(request.getEmployeeMobNo());
                empEntity.setEmployeeAddress(request.getEmployeeAddress());
                System.out.println(empEntity);
                employeeRepository.save(empEntity);
                response.setMessage("Success");
                response.setStatusCode("200");
                response.setLstEmployee(Collections.singletonList(empEntity));
            }
        } catch (Exception ex) {
            response.setMessage("Exception" + ex.getMessage());
            response.setStatusCode("200");

        }
        return response;
    }

}
