package com.example.jesper.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Monthly Report Entity Class
 *
 * @author Md. Alamin Hossain
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "monthly_report")
@Entity
public class MonthlyReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String employeeName;
    private String month;
    private int totalDay;
    private int present;
    private int absent;
}
