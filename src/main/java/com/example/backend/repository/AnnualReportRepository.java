package com.example.backend.repository;

import com.example.backend.entity.AnnualReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnualReportRepository extends JpaRepository<AnnualReport, Integer> {
}