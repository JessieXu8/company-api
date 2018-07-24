package com.oocl.companyapi;

import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
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
    public void should_return_size_is_1_of_employees_when_call_getEmployees_successful() {
        Employee newEmployee = new Employee();
        employeeService.addEmployee(newEmployee);
        List<Employee> result = employeeService.getEmployee();
        assertThat(result.size(), is(1));
    }

    @Test
    public void should_return_Employee_when_call_findEmployeeById_successful() {
        Employee newEmployee = new Employee(1, "abibaba1", 20, "male", 6000);
        employeeService.addEmployee(newEmployee);
        Employee result = employeeService.findEmployeeById(1);
        assertThat(result, is(newEmployee));
    }

    @Test
    public void should_return_size_is_1_when_call_findEmployeeByGender_successful() {
        Employee newEmployee1 = new Employee(1, "abibaba1", 20, "male", 6000);
        employeeService.addEmployee(newEmployee1);
        Employee newEmployee2 = new Employee(2, "abibaba1", 20, "female", 6000);
        employeeService.addEmployee(newEmployee2);
        List<Employee> result = employeeService.findEmployeesByGender("male");
        assertThat(result.size(), is(1));
    }

    @Test
    public void should_return_Employee_when_call_updateEmployee_successful() {
        Employee Employee = new Employee(1, "abibaba1", 20, "male", 6000);
        employeeService.addEmployee(Employee);
        Employee newEmployee = new Employee(1, "abibaba1", 21, "male", 6000);
        Employee employee = employeeService.updateEmployee(1,newEmployee);


        assertThat(employee.getAge(), is(20));
    }
}
