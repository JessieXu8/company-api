package com.oocl.companyapi;

import com.oocl.companyapi.entity.Company;
import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.CompanyService;
import com.oocl.companyapi.service.EmployeeService;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CompanyTests {
    CompanyService companyService = new CompanyService();
    @Test
    public void should_return_companies_when_call_addCompanies_successful() {
        Company company = new Company();
        Company result = companyService.addCompany(company);
        assertThat(result,is(company));
    }
    @Test
    public void should_return_size_is_1_of_companies_when_call_getCompany_successful() {
        Company company = new Company();
        companyService.addCompany(company);
        List<Company> result = companyService.getCompanies();
        assertThat(result.size(), is(1));
    }
    @Test
    public void should_return_Company_when_call_getCompanyById_successful() {
        Company company = new Company(1);
        companyService.addCompany(company);
        Company result = companyService.getCompanyById(1);
        assertThat(result, is(company));
    }

    @Test
    public void should_return_Employees_of_Company_when_call_getEmployeesOfCompanyById_successful() {
        Employee employee = new Employee();
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(employee);
        Company company = new Company(1,"ali","200",employeeService.getEmployee());
        companyService.addCompany(company);
        List<Employee> result = companyService.getEmployeesOfCompanyById(1);
        assertThat(result.size(), is(1));
    }

    @Test
    public void should_return_update_Company_when_call_updateCompany_successful() {
        Company company = new Company(1);
        companyService.addCompany(company);
        Company result = companyService.updateCompanies(1,new Company(2));
        assertThat(result.getCompanyId(), is(1));
    }
}
