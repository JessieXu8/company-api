package com.oocl.companyapi.controller;

import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addEmployees(@RequestBody Employee newEmployee){
        return employeeService.addEmployee(newEmployee);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeesById(@PathVariable int id){
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/employees/male")
    public List<Employee> findEmployeesByGender(){
        String gender = "male";
        return employeeService.findEmployeesByGender(gender);
    }
}
