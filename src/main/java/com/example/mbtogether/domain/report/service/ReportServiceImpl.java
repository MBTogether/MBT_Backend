package com.example.mbtogether.domain.report.service;

import com.example.mbtogether.domain.report.controller.Request.ReportDto;
import com.example.mbtogether.domain.report.entity.PostReport;
import com.example.mbtogether.domain.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    private final ReportRepository reportRepository;

    @Override
    public void report(ReportDto dto) {
        PostReport report = new PostReport(dto.getPost_id(), dto.getContent());
        reportRepository.save(report);
    }
}
