package com.oocl.companyapi;
import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTests {
    EmployeeService employeeService;
    @Test
    public void should_return_all_employees_when_call_getEmployees_successful(){
        Employee newEmployee = new Employee();
        employeeService = new EmployeeService();
        Employee result = employeeService.addEmployee(newEmployee);
        assertThat(result,is(newEmployee));
//        employeeService.getEmployees()
   }
}
