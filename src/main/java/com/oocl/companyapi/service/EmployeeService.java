package com.oocl.companyapi.service;

import com.oocl.companyapi.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Employee delEmployee(int id) {
        if(employees.containsKey(id)){
            return employees.remove(id);
        }
        return null;
    }

    public List<Employee> showEmployeesByPage(int page, int pageSize) {
        List<Employee> employeesList = getEmployee();
        List<Employee> employeeListByPage = new ArrayList<>();
        int pagesNum = employees.size()/pageSize+1;
        if(page>pagesNum){
            return null;
        }else {
            if (page*pageSize <=employees.size()){
                employeeListByPage =employeesList.subList((page-1)*pageSize,(page-1)*pageSize+5);
            }else {
                employeeListByPage=employeesList.subList((page-1)*pageSize,employees.size());
            }
            return employeeListByPage;
        }
    }
}
