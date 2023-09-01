package com.example.jesper.controller;

import com.example.jesper.service.JasperReportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Jasper Report Generation Controller
 *
 * @author Md. Alamin Hossain
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class JasperController {
    private final JasperReportService jasperReportService;

    /**
     * Create Jasper report endpoint
     *
     * @return Success Message and Http Status
     * @throws JRException if any error in compilation of the report
     */
    @GetMapping
    public ResponseEntity<String> generateReport() throws JRException {
        jasperReportService.generateJasperReport();
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
