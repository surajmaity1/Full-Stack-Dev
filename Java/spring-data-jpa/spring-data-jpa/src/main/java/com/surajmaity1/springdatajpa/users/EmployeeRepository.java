package com.surajmaity1.springdatajpa.users;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//}
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByEmpFirstName(String empFirstName);
    List<Employee> findByEmpDeptNo(Integer empDeptNo);
}