package com.oocl.companyapi.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Company {
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(String employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Company(int companyId) {
        this.companyId = companyId;
    }
    public Company() {
    }
    private int companyId;
    private String companyName;
    private String employeesNumber;
    private List<Employee> employees;
}
