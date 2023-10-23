package com.surajmaity1.springbootrestapi.service;

import com.surajmaity1.springbootrestapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee getEmployeeDetails(String empId);
    public List<Employee> getAllEmployeeDetails();
    public List<Employee> getByEmpName(String empName);
    public String registerEmployee(Employee employee);
    public String updateEmployeeDetails(Employee employee);
    public String removeEmployeeDetails(String empId);
}
