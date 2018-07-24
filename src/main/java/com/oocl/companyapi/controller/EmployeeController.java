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

    @PutMapping("/employees/{id}")
    public Employee updateEmployees(@PathVariable int id,@RequestBody Employee newEmployee){
        return employeeService.updateEmployee(id,newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Employee delEmployees(@PathVariable int  id){
        return employeeService.delEmployee(id);
    }

    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    public List<Employee> showEmployeesByPage(@PathVariable int  page,@PathVariable int  pageSize){
        return employeeService.showEmployeesByPage(page,pageSize);
    }
}
