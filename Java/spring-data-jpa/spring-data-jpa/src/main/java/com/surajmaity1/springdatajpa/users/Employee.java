package com.surajmaity1.springdatajpa.users;


import jakarta.persistence.*;

@Entity(name = "Employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name = "emp_seq",
            sequenceName = "emp_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "emp_seq"
    )
    @Column(
            name = "emp_id",
            updatable = false
    )
    private Long empId;

    @Column(
            name = "emp_first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String empFirstName;

    @Column(
            name = "emp_last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String empLastName;


    @Column(
            name = "emp_email",
            unique = true,
            columnDefinition = "TEXT"
    )
    private String empEmail;

    @Column(name = "emp_dept_no")
    private Integer empDeptNo;

    public Employee(Long empId, String empFirstName, String empLastName,
                    String empEmail, Integer empDeptNo) {
        this.empId = empId;
        this.empFirstName = empFirstName;
        this.empLastName = empLastName;
        this.empEmail = empEmail;
        this.empDeptNo = empDeptNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empDeptNo=" + empDeptNo +
                '}';
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public Integer getEmpDeptNo() {
        return empDeptNo;
    }

    public void setEmpDeptNo(Integer empDeptNo) {
        this.empDeptNo = empDeptNo;
    }
}
