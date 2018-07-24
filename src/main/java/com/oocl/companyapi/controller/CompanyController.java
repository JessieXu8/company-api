package com.oocl.companyapi.controller;

import com.oocl.companyapi.entity.Company;
import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/companies")
    public Company addCompany(@RequestBody Company newCompany){
        return companyService.addCompany(newCompany);
    }

    @GetMapping("/companies")
    public List<Company> getCompanies(){
        return companyService.getCompanies();
    }

    @GetMapping("/companies/{id}")
    public Company getCompanyById(@PathVariable int id){
        return companyService.getCompanyById(id);
    }

    @GetMapping("/companies/{id}/employees")
    public List<Employee> getEmployeesOfCompanyById(@PathVariable int id){
        return companyService.getEmployeesOfCompanyById(id);
    }
    @PutMapping("/companies/{id}")
    public Company updateCompanies(@PathVariable int id,@RequestBody Company newCompany){
        return companyService.updateCompanies(id,newCompany);
    }
    @DeleteMapping("/companies/{id}")
    public Company delCompany(@PathVariable int  id){
        return companyService.delCompany(id);
    }
    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public List<Company> getCompaniesByPage(@PathVariable int page,@PathVariable int pageSize){
        return companyService.getCompaniesByPage(page,pageSize);
    }
}
