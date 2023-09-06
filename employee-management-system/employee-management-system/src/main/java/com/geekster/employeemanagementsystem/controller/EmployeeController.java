package com.geekster.employeemanagementsystem.controller;

import com.geekster.employeemanagementsystem.model.Employee;
import com.geekster.employeemanagementsystem.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
   @GetMapping("/hello")
    public String helloWorld(){
        return "hello sohit";
    }

    @PostMapping("/createEmployee")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee){
       return employeeService.createEmployee(employee);
    }
    @GetMapping("getAllEmployee")
    public List<Employee>  getAllEmployee(){
       return employeeService.allEmployee();
    }
    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee){
       return employeeService.updateEmployeeById(id, employee);
    }
}
