package com.yuuki.crudapi.controller;

import com.yuuki.crudapi.ResourceNotFoundException;
import com.yuuki.crudapi.entity.Employee;
import com.yuuki.crudapi.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;


@RestController
public class EmployController {

    private EmployeeService employeeService;

    public EmployController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 全ての従業員を取得するメソッド
    @GetMapping("/employees")
    public List<EmployeeResponse> employees() {
        List<Employee> employees = employeeService.findAll();
        List<EmployeeResponse> employeeResponses = employees.stream().map(EmployeeResponse::new).toList();
        return employeeResponses;
    }

    // 特定のIDの従業員を取得するメソッド
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) throws Exception {
        return employeeService.findById(id);
    }

    // 特定の部署の従業員を取得するメソッド
    @GetMapping("/employees/department")
    public List<Employee> getEmployeeByDepartment(@RequestParam(value = "name", required = false) String department) {
        return employeeService.findByDepartment(department);
    }

    // ResourceNotFoundException がスローされた場合のハンドラ
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
