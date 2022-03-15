package com.example.mbtogether.domain.report.controller;

import com.example.mbtogether.domain.report.controller.Request.ReportDto;
import com.example.mbtogether.domain.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/board/report")
    public void report(@RequestBody ReportDto dto){
        reportService.report(dto);
    }
}
