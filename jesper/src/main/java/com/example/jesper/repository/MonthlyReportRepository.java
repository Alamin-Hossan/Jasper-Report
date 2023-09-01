package com.example.jesper.repository;

import com.example.jesper.entity.MonthlyReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Monthly Report JPA Repository
 *
 * @author Md. Alamin Hossain
 */
@Repository
public interface MonthlyReportRepository extends JpaRepository<MonthlyReport, Integer> {
}
