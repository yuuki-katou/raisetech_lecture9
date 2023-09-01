package com.yuuki.crudapi.service;

import com.yuuki.crudapi.ResourceNotFoundException;
import com.yuuki.crudapi.entity.Employee;
import com.yuuki.crudapi.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    // 全ての従業員を取得するメソッド
    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    // 特定のIDの従業員を取得するメソッド
    @Override
    public Employee findById(int id) {
        Optional<Employee> employee = this.employeeMapper.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new ResourceNotFoundException("resource not found");
        }
    }

    // 特定の部署の従業員を取得するメソッド
    @Override
    public List<Employee> findByDepartment(String department) {
        List<Employee> employee = this.employeeMapper.findByDepartment(department);
        if (employee.isEmpty()) {
            throw new ResourceNotFoundException("resource not found");
        } else {
            return employee;
        }
    }


}

