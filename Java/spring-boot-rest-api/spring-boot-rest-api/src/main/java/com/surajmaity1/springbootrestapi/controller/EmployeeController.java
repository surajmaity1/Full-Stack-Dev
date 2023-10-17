package com.surajmaity1.springbootrestapi.controller;

import com.surajmaity1.springbootrestapi.model.Employee;
import com.surajmaity1.springbootrestapi.response.ResponseHandler;
import com.surajmaity1.springbootrestapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get specific Employee Details by empId
    @GetMapping("{empId}")
    public ResponseEntity<Object> getEmployeeDetails(@PathVariable("empId") String empId) {
        return ResponseHandler.responseBuilder(
                "Provided Employee Info.",
                HttpStatus.OK,
                employeeService.getEmployeeDetails(empId)
        );
    }

    // get all Employee Details
    @GetMapping()
    public List<Employee> getAllEmployeeDetails() {
        return employeeService.getAllEmployeeDetails();
    }

    @PostMapping
    public String registerEmployee(@RequestBody Employee employee) {
        employeeService.registerEmployee(employee);
        return "SUCCESS: Employee Registered !!";
    }

    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee) {
        employeeService.updateEmployeeDetails(employee);
        return "SUCCESS: Employee Updated !!";
    }

    @DeleteMapping("{empId}")
    public String removeEmployeeDetails(@PathVariable("empId") String empId) {
        employeeService.removeEmployeeDetails(empId);
        return "SUCCESS: Employee Details Removed !!";
    }
}
