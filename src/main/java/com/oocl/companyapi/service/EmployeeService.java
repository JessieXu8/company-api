package com.oocl.companyapi.service;

import com.oocl.companyapi.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private Map<Integer,Employee> employees = new HashMap<>();

    public Employee addEmployee(Employee newEmployee) {
        employees.put(newEmployee.getId(),newEmployee);
        return newEmployee;
    }

    public List<Employee> getEmployee() {
        List<Employee> employeesList = new ArrayList<>();
        for (Integer id : employees.keySet()){
            employeesList.add(employees.get(id));
        }
        return employeesList;
    }

    public Employee findEmployeeById(int id) {
        if(employees.containsKey(id)){
            return employees.get(id);
        }
        return null;
    }

    public List<Employee> findEmployeesByGender(String gender) {
        List<Employee> employeesList = new ArrayList<>();
        for (Integer id : employees.keySet()){
            if(employees.get(id).getGender().equals(gender)) {
                employeesList.add(employees.get(id));
            }
        }
        return employeesList;
    }

    public Employee updateEmployee(int id, Employee newEmployee) {
        if(employees.containsKey(id)){
            return employees.replace(id,newEmployee);
        }
        return null;
    }
}
