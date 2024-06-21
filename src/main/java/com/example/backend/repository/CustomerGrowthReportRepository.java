package com.example.backend.repository;
import com.example.backend.entity.CustomerGrowthReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGrowthReportRepository extends JpaRepository<CustomerGrowthReport, Integer> {
}