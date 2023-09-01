package com.example.jesper.service;

import com.example.jesper.dto.MonthlyReportDTO;
import com.example.jesper.entity.MonthlyReport;
import com.example.jesper.repository.MonthlyReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Monthly Report Service Class
 *
 * @author Md. Alamin Hossain
 */
@Service
@RequiredArgsConstructor
public class MonthlyReportService {
    private final MonthlyReportRepository monthlyReportRepository;

    /**
     * Get All the Monthly Report DTO list
     *
     * @return monthlyReportDTO List
     */
    public List<MonthlyReportDTO> getAllMonthlyReport() {
        List<MonthlyReport> monthlyReportList = monthlyReportRepository.findAll();
        return monthlyReportList.stream().map((monthlyReport -> {
            return new MonthlyReportDTO(monthlyReport.getEmployeeName(), monthlyReport.getMonth(), monthlyReport.getTotalDay(), monthlyReport.getPresent(), monthlyReport.getAbsent());
        })).collect(Collectors.toList());
    }
}
