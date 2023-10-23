package com.surajmaity1.springbootrestapi.service.impl;

import com.surajmaity1.springbootrestapi.excep.EmployeeNotFoundException;
import com.surajmaity1.springbootrestapi.model.Employee;
import com.surajmaity1.springbootrestapi.repository.EmployeeRepository;
import com.surajmaity1.springbootrestapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployeeDetails(String empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Exist With Given Credentials");
        }
        return employee.get();
    }

    @Override
    public List<Employee> getAllEmployeeDetails() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByEmpName(String empName) {
        return employeeRepository.findByEmpName(empName);
    }

    @Override
    public String registerEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "REGISTERED";
    }

    @Override
    public String updateEmployeeDetails(Employee employee) {
        employeeRepository.save(employee);
        return "UPDATED";
    }

    @Override
    public String removeEmployeeDetails(String empId) {
        employeeRepository.deleteById(empId);
        return "REMOVED";
    }
}
