package com.example.backend.service;
import com.example.backend.dto.sale.StatusCountStatsDto;
import com.example.backend.entity.AnnualReport;
import com.example.backend.entity.CustomerGrowthReport;
import com.example.backend.entity.TopSalesCustomer;
import com.example.backend.entity.TopSalesProduct;

import java.util.List;

public interface StatsService {

    StatusCountStatsDto getStatusCountStats();

    List<AnnualReport> getAnnualReport();

    List<CustomerGrowthReport> getCustomerGrowthReport();

    List<TopSalesCustomer> getTopSalesCustomers(Integer year, Integer month);

    List<TopSalesProduct> getTopSalesProducts(Integer year, Integer month);

}
