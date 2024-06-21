package com.example.backend.service.impl;

import com.example.backend.dto.sale.HumanStatsDto;
import com.example.backend.dto.sale.OrderStatusDto;
import com.example.backend.dto.sale.ProductStatusDto;
import com.example.backend.dto.sale.StatusCountStatsDto;
import com.example.backend.entity.AnnualReport;
import com.example.backend.entity.CustomerGrowthReport;
import com.example.backend.entity.TopSalesCustomer;
import com.example.backend.entity.TopSalesProduct;
import com.example.backend.repository.*;
import com.example.backend.service.StatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatsServiceImpl implements StatsService {

    private final EmployeeRepository employeeRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final MadeInRepository madeInRepository;
    private final OrdersRepository ordersRepository;
    private final AnnualReportRepository annualReportRepository;
    private final CustomerGrowthReportRepository customerGrowthReportRepository;
    private final TopSalesCustomerRepository topSalesCustomerRepository;
    private final TopSalesProductRepository topSalesProductRepository;

    @Override
    public StatusCountStatsDto getStatusCountStats() {
        HumanStatsDto employeeStats = new HumanStatsDto();
        employeeStats.setActive(employeeRepository.countByStatus(1));
        employeeStats.setInactive(employeeRepository.countByStatus(0));

        HumanStatsDto customerStats = new HumanStatsDto();
        customerStats.setActive(customerRepository.countByStatus(1));
        customerStats.setInactive(customerRepository.countByStatus(0));

        ProductStatusDto productStats = new ProductStatusDto();
        productStats.setActive(productRepository.countByStatus(1));
        productStats.setInactive(productRepository.countByStatus(-1));
        productStats.setOutOfStock(productRepository.countByStatus(0));
        ProductStatusDto.CategoryStatusDto categoryStats = new ProductStatusDto.CategoryStatusDto();
        categoryStats.setActive(categoryRepository.countByStatus(1));
        categoryStats.setInactive(categoryRepository.countByStatus(0));
        ProductStatusDto.BrandStatusDto brandStats = new ProductStatusDto.BrandStatusDto();
        brandStats.setActive(brandRepository.countByStatus(1));
        brandStats.setInactive(brandRepository.countByStatus(0));
        productStats.setCategoryStats(categoryStats);
        productStats.setBrandStats(brandStats);
        productStats.setAllMadeIns((long) madeInRepository.findAll().size());

        OrderStatusDto orderStats = new OrderStatusDto();
        orderStats.setWaitConfirm(ordersRepository.countByStatus(0));
        orderStats.setConfirmed(ordersRepository.countByStatus(1));
        orderStats.setWaitPrepare(ordersRepository.countByStatus(2));
        orderStats.setShipping(ordersRepository.countByStatus(3));
        orderStats.setShipped(ordersRepository.countByStatus(4));
        orderStats.setCancelled(ordersRepository.countByStatus(5));
        orderStats.setPaid(ordersRepository.countByPaymentStatus(true));
        orderStats.setUnpaid(ordersRepository.countByPaymentStatus(false));

        StatusCountStatsDto statusCountStats = new StatusCountStatsDto();
        statusCountStats.setEmployeeStats(employeeStats);
        statusCountStats.setCustomerStats(customerStats);
        statusCountStats.setProductStatusDto(productStats);
        statusCountStats.setOrderStatusDto(orderStats);

        return statusCountStats;
    }

    @Override
    public List<AnnualReport> getAnnualReport() {
        annualReportRepository.deleteAll();
        return annualReportRepository.saveAll(ordersRepository.revenueByMonthYear());
    }

    @Override
    public List<CustomerGrowthReport> getCustomerGrowthReport() {
        customerGrowthReportRepository.deleteAll();
        return customerGrowthReportRepository.saveAll(customerRepository.getCustomerGrowthReport());
    }

    @Override
    public List<TopSalesCustomer> getTopSalesCustomers(Integer year, Integer month) {
        if (year == null && month != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phải chọn năm nếu như chọn tháng");
        topSalesCustomerRepository.deleteAll();
        if (year == null && month == null)
            return topSalesCustomerRepository.saveAll(ordersRepository.topSalesCustomers());
        if (year != null && month == null)
            return topSalesCustomerRepository.saveAll(ordersRepository.topSalesCustomersByYear(year));
        return topSalesCustomerRepository.saveAll(ordersRepository.topSalesCustomersByYearAndMonth(year, month));
    }

    @Override
    public List<TopSalesProduct> getTopSalesProducts(Integer year, Integer month) {
        if (year == null && month != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Phải chọn năm nếu như chọn tháng");
        topSalesProductRepository.deleteAll();
        if (year == null && month == null)
            return topSalesProductRepository.saveAll(topSalesProductRepository.getTopSalesProduct());
        if (year != null && month == null)
            return topSalesProductRepository.saveAll(topSalesProductRepository.getTopSalesProductByYear(year));
        return topSalesProductRepository.saveAll(topSalesProductRepository.getTopSalesProductByYearAndMonth(year, month));
    }
}
