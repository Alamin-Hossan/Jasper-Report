package com.example.jesper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Jasper Employee table information DTO
 *
 * @author Md. Alamin Hossain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String name;
    private String address;
    private String designation;
    private String employeeId;
}
