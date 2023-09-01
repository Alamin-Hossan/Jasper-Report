package com.example.jesper.service;

import com.example.jesper.dto.EmployeeDTO;
import com.example.jesper.dto.MonthlyReportDTO;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Jesper Report Creating service class
 *
 * @author Md. Alamin Hossain
 */
@Service
@RequiredArgsConstructor
public class JasperReportService {
    private final EmployeeService employeeService;
    private final MonthlyReportService monthlyReportService;

    /**
     * Generating the Jasper Report -> convert to pdf -> save to a location
     *
     * @throws JRException for file compilation error
     */
    public void generateJasperReport() throws JRException {
        String filePath = "D:\\Demo Project\\jesper\\src\\main\\resources\\templates\\employeeReport.jrxml";

        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployeeInformation();

        JRBeanCollectionDataSource employeeDataSource = new JRBeanCollectionDataSource(employeeDTOList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("Name", "Alamin Hossain");
        parameters.put("address", "Kuril, Dhaka");
        parameters.put("Employee ID", "BJIT-1");
        parameters.put("EmployeeData", employeeDataSource);
        parameters.put("monthlySubReport", getMonthlyReport());
        parameters.put("monthlyParameter", getMonthlyParameters());

        // Compile the form the .jrxml directory
        JasperReport report = JasperCompileManager.compileReport(filePath);

        // to set force colour by specific koy value
        JRStaticText generatedText = (JRStaticText) report.getPageHeader().getElementByKey("generated_date");
        generatedText.setForecolor(Color.blue);

        // generate the pdf with all the data and export to a specific report type
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "D:\\Demo Project\\jesper\\src\\main\\resources\\templates\\report.pdf");
    }

    /**
     * Creates the Objects of Sub-report
     *
     * @return list of Objects
     */
    private JRBeanCollectionDataSource getMonthlyDataSource() {
        List<MonthlyReportDTO> monthlyReportList = monthlyReportService.getAllMonthlyReport();
        return new JRBeanCollectionDataSource(monthlyReportList);
    }

    /**
     * Map the Objects parameter for connecting or passing from the main report
     *
     * @return reportParameter for subReport
     */
    private Map<String, Object> getMonthlyParameters() {
        Map<String, Object> monthlyReportParameter = new HashMap<>();
        monthlyReportParameter.put("monthlyInfo", getMonthlyDataSource());
        return monthlyReportParameter;
    }

    /**
     * Get the sub report details and extract from the data .jrxml file and compile the report
     *
     * @return compiled report
     * @throws JRException for file compilation failure
     */
    private JasperReport getMonthlyReport() throws JRException {
        String filePath2 = "D:\\Demo Project\\jesper\\src\\main\\resources\\templates\\monthlyEmployeeSubReport.jrxml";
        return JasperCompileManager.compileReport(filePath2);
    }
}
