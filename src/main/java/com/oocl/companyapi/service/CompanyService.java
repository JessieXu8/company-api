package com.oocl.companyapi.service;

import com.oocl.companyapi.entity.Company;
import com.oocl.companyapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {
    @Autowired
    EmployeeService employeeService;
    private Map<Integer,Company> companies = new HashMap<>();

    public Company addCompany(Company newCompany) {
        companies.put(newCompany.getCompanyId(),newCompany);
        return newCompany;
    }

    public List<Company> getCompanies() {
        List<Company> employeesList = new ArrayList<>();
        for (Integer id : companies.keySet()){
            employeesList.add(companies.get(id));
        }
        return employeesList;
    }

    public Company getCompanyById(int id) {
        if(companies.containsKey(id)){
            return companies.get(id);
        }
        return null;
    }

    public List<Employee> getEmployeesOfCompanyById(int id) {
        if(companies.containsKey(id)){
            return companies.get(id).getEmployees();
        }
        return null;
    }

    public Company updateCompanies(int id, Company newCompany) {
        if(companies.containsKey(id)){
            return companies.replace(id,newCompany);
        }
        return null;
    }

    public Company delCompany(int id) {
        if(companies.containsKey(id)){
            return companies.remove(id);
        }
        return null;
    }

}
