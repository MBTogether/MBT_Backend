package com.example.mbtogether.domain.report.repository;

import com.example.mbtogether.domain.report.entity.PostReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<PostReport, Integer> {
}
