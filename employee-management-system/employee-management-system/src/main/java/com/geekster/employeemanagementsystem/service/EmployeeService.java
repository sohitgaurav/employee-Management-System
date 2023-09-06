package com.geekster.employeemanagementsystem.service;

import com.geekster.employeemanagementsystem.model.Employee;
import com.geekster.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public ResponseEntity<String> createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return new  ResponseEntity<>("successfully created employee", HttpStatus.CREATED);
    }

    public List<Employee> allEmployee() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<String> updateEmployeeById(int id, Employee employee) {
        if(!employeeRepository.findById(id).isPresent()){
            return new ResponseEntity<>("employee id does not exist", HttpStatus.NOT_FOUND);
        }
        Employee employeeDetail = employeeRepository.findById(id).get();
        if(employee.getEmail()!=null){
            employeeDetail.setEmail(employee.getEmail());
        }
        if(employee.getPhoneNumber()!=null){
            employeeDetail.setPhoneNumber(employee.getPhoneNumber());
        }
        if(employee.getSalary()!=0){
            employeeDetail.setSalary(employee.getSalary());
        }
        if(employee.getFirstName()!=null){
            employeeDetail.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName()!=null){
            employeeDetail.setLastName(employee.getLastName());
        }
        if(employee.getAddress()!=null){
            employeeDetail.setAddress(employee.getAddress());
        }
        if(employee.getJobRole()!=null){
            employeeDetail.setJobRole(employee.getJobRole());
        }

        employeeRepository.save(employeeDetail);
        return new ResponseEntity<>("Successfully updated employee record" ,HttpStatus.OK);
    }
}
