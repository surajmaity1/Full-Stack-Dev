package com.surajmaity1.springbootrestapi.controller;

import com.surajmaity1.springbootrestapi.model.Employee;
import com.surajmaity1.springbootrestapi.response.ResponseHandler;
import com.surajmaity1.springbootrestapi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
@Tag(name = "Employee", description = "Employee Table")
public class EmployeeController {

    EmployeeService employeeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get specific Employee Details by empId
    @GetMapping("/{empId}")
    @Operation(
            description = "Employee Details Provided",
            summary = "Employee ID",
            responses = {
                @ApiResponse(
                        description = "Success",
                        responseCode = "200"
                ),
                @ApiResponse(
                        description = "Unauthorized / Invalid Token",
                        responseCode = "403"
                )
            }
    )
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
        LOGGER.info("Employee Created");
        LOGGER.debug("Employee Debug Logger enabled");
        return "SUCCESS: Employee Registered !!";
    }

    @PutMapping
    public String updateEmployeeDetails(@RequestBody Employee employee) {
        employeeService.updateEmployeeDetails(employee);
        return "SUCCESS: Employee Updated !!";
    }

    @DeleteMapping("/{empId}")
    public String removeEmployeeDetails(@PathVariable("empId") String empId) {
        employeeService.removeEmployeeDetails(empId);
        return "SUCCESS: Employee Details Removed !!";
    }
}
