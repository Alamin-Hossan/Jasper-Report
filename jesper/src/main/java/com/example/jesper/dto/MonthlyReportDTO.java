package com.example.jesper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Monthly Sub report creation DTO
 *
 * @author Md. Alamin Hossain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyReportDTO {
    private String employeeName;
    private String month;
    private int totalDay;
    private int present;
    private int absent;
}
