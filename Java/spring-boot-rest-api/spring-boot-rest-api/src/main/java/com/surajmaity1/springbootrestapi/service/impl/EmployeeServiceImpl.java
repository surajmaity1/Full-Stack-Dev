package com.surajmaity1.springbootrestapi.service.impl;

import com.surajmaity1.springbootrestapi.model.Employee;
import com.surajmaity1.springbootrestapi.repository.EmployeeRepository;
import com.surajmaity1.springbootrestapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeDetails(String empId) {
        return employeeRepository.findById(empId).get();
    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public String registerEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "msg: Employee registered successfully.";
    }

    @Override
    public String updateEmployeeDetails(Employee employee) {
        employeeRepository.save(employee);
        return "msg: Employee updated successfully.";
    }

    @Override
    public String removeEmployeeDetails(String empId) {
        employeeRepository.deleteById(empId);
        return "msg: Employee removed successfully.";
    }
}
