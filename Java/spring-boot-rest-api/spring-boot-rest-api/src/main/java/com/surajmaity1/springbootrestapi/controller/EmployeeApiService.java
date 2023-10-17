package com.surajmaity1.springbootrestapi.controller;

import com.surajmaity1.springbootrestapi.model.Employee;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emp")
public class EmployeeApiService {

    Employee employee;

    @GetMapping("{empId}")
    public Employee getEmployeeDetails(String empId) {
        // return new Employee("E1", "Employee 1", "Address 1", "PhNo 1");
        return employee;
    }

    @PostMapping
    public String registerEmployee(@RequestBody Employee employee) {
        this.employee = employee;
        return "SUCCESS: Employee Registered !!";
    }

    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee) {
        this.employee = employee;
        return "SUCCESS: Employee Updated !!";
    }

    @DeleteMapping("{empId}")
    public String removeEmployeeDetails(String empId) {
        this.employee = null;
        return "SUCCESS: Employee Details Removed !!";
    }
}
