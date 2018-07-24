package com.oocl.companyapi.controller;

import com.oocl.companyapi.entity.Employee;
import com.oocl.companyapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee getEmployees(@RequestBody Employee newEmployee){
        return employeeService.addEmployee(newEmployee);
    }

//    @GetMapping("/employees")
//    public List<Employee> getEmployees(){
//        return employeeService.getEmployee();
//    }
}
