package com.example.jesper.controller;

import com.example.jesper.dto.EmployeeDTO;
import com.example.jesper.entity.Employee;
import com.example.jesper.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Employee Controller
 *
 * @author Md. Alamin Hossain
 */
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    /**
     * Get All the Employee Information
     *
     * @return Employee List and HTTP status
     */
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployeeInformation(), HttpStatus.OK);
    }
}
