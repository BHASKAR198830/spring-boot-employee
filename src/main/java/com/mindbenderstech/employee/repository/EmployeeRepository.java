package com.mindbenderstech.employee.repository;

import com.mindbenderstech.employee.dto.Request;
import com.mindbenderstech.employee.dto.Response;
import com.mindbenderstech.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {


}
