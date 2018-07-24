package com.oocl.companyapi;

import com.oocl.companyapi.entity.Company;
import com.oocl.companyapi.service.CompanyService;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CompanyTests {
    CompanyService companyService = new CompanyService();
    @Test
    public void should_return_all_companies_when_call_addCompanies_successful() {
        Company company = new Company();
        Company result = companyService.addCompany(company);
        assertThat(result,is(company));
    }
}
