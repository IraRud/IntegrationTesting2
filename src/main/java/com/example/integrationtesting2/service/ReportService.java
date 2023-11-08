package com.example.integrationtesting2.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;


public interface ReportService {
    Integer addReport();
    ResponseEntity<Resource> getReportById(Integer id);
}
