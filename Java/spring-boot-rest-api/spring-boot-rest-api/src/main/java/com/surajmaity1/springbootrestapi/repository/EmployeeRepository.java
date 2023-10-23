package com.surajmaity1.springbootrestapi.repository;

import com.surajmaity1.springbootrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findByEmpName(String empName);
}
