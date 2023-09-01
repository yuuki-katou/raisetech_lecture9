package com.yuuki.crudapi.service;

import com.yuuki.crudapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id) throws Exception;

    List<Employee> findByDepartment(String department);


}


