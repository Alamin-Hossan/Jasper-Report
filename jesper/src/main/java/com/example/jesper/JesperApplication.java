package com.example.jesper;

import net.sf.jasperreports.engine.JRException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JesperApplication {

    public static void main(String[] args) throws JRException {
        SpringApplication.run(JesperApplication.class, args);
    }
}
