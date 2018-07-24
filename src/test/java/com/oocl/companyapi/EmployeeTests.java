package com.oocl.companyapi;

import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTests {
    EmployeeService employeeService = new EmployeeService();

    @Test
    public void should_return_all_employees_when_call_addEmployees_successful() {
        Employee newEmployee = new Employee(1, "abibaba1", 20, "male", 6000);
        Employee result = employeeService.addEmployee(newEmployee);
        assertThat(result, is(newEmployee));
    }

    @Test
    public void should_return_all_employees_when_call_getEmployees_successful() {
        Employee newEmployee = new Employee();
        employeeService.addEmployee(newEmployee);
        List<Employee> result = employeeService.getEmployee();
        assertThat(result.size(), is(1));
    }
}
