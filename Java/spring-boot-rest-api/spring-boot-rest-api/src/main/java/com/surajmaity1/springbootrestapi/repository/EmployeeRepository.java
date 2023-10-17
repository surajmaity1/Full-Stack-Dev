package com.surajmaity1.springbootrestapi.repository;

import com.surajmaity1.springbootrestapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
