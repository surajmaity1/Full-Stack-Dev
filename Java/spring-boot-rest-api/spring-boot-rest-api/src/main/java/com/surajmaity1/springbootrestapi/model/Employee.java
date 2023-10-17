package com.surajmaity1.springbootrestapi.model;

public class Employee {
    private String empId;
    private String empName;
    private String empAddress;
    private String empPhNo;

    public Employee() {

    }

    public Employee(String empId, String empName, String empAddress, String empPhNo) {
        this.empId = empId;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empPhNo = empPhNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpPhNo() {
        return empPhNo;
    }

    public void setEmpPhNo(String empPhNo) {
        this.empPhNo = empPhNo;
    }
}
