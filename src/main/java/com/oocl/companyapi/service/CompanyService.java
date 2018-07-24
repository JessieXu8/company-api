package com.oocl.companyapi.service;

import com.oocl.companyapi.entity.Company;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {
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
}
