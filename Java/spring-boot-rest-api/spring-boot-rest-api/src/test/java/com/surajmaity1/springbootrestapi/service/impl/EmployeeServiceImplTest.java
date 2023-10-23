package com.surajmaity1.springbootrestapi.service.impl;

import com.surajmaity1.springbootrestapi.model.Employee;
import com.surajmaity1.springbootrestapi.repository.EmployeeRepository;
import com.surajmaity1.springbootrestapi.service.EmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    private EmployeeService employeeService;

    AutoCloseable autoCloseable;

    Employee employee;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        employee = new Employee("1", "Dk Dey",
                "Patna", "23");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void testGetEmployeeDetails() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findById("1")).thenReturn(Optional.ofNullable(employee));
        assertThat(employeeService.getEmployeeDetails("1")
                .getEmpName()).isEqualTo(employee.getEmpName());
    }

    @Test
    void testGetAllEmployeeDetails() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findAll()).thenReturn(
                new ArrayList<>(Collections.singleton(employee))
        );
        assertThat(employeeService.getAllEmployeeDetails().get(0)
                .getEmpAddress()).isEqualTo(employee.getEmpAddress());
    }

    @Test
    void testRegisterEmployee() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.registerEmployee(employee))
                .isEqualTo("REGISTERED");
    }

    @Test
    void testUpdateEmployeeDetails() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.save(employee)).thenReturn(employee);
        assertThat(employeeService.updateEmployeeDetails(employee))
                .isEqualTo("UPDATED");
    }

    @Test
    void testRemoveEmployeeDetails() {
        mock(Employee.class);
        mock(EmployeeRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
                employeeRepository).deleteById(any());
        assertThat(employeeService.removeEmployeeDetails("1"))
                .isEqualTo("REMOVED");
    }

    @Test
    void testGetByEmpName() {
        mock(Employee.class);
        mock(EmployeeRepository.class);

        when(employeeRepository.findByEmpName("Dk Dey")).thenReturn(
                new ArrayList<>(Collections.singleton(employee))
        );
        assertThat(employeeService.getByEmpName("Dk Dey").get(0).getEmpId())
                .isEqualTo(employee.getEmpId());
    }
}