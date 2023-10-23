package com.surajmaity1.springbootrestapi.repository;

import com.surajmaity1.springbootrestapi.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee("1", "Dk Dey",
                "Patna", "23");
        employeeRepository.save(employee);
    }

    @AfterEach
    void tearDown() {
        employee = null;
        employeeRepository.deleteAll();
    }

    // TEST CASE SUCCESS CHECKING
    @Test
    void testFindByEmpName_Found() {
        List<Employee> employeeList = employeeRepository.findByEmpName("Dk Dey");
        assertThat(employeeList.get(0).getEmpId()).isEqualTo(employee.getEmpId());
        assertThat(employeeList.get(0).getEmpAddress()).isEqualTo(
                employee.getEmpAddress()
        );
    }

    // TEST CASE FAILURE CHECKING
    @Test
    void testFindByEmpName_NotFound() {
        List<Employee> employeeList = employeeRepository.findByEmpName("Manoj Roy");
        assertThat(employeeList.isEmpty()).isTrue();
    }
}
