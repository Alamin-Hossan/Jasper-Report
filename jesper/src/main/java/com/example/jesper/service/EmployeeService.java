package com.example.jesper.service;

import com.example.jesper.dto.EmployeeDTO;
import com.example.jesper.entity.Employee;
import com.example.jesper.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Employee Service
 *
 * @author Md. Alamin Hossain
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    /**
     * Get All the Employee Information
     *
     * @return employeeDTO List
     */
    public List<EmployeeDTO> getAllEmployeeInformation() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map((employee -> {
            return new EmployeeDTO(employee.getName(), employee.getAddress(), employee.getDesignation(), employee.getEmployeeId());
        })).collect(Collectors.toList());
    }
}
