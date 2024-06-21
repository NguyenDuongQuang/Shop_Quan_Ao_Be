package com.example.backend.repository;
import com.example.backend.entity.TopSalesCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopSalesCustomerRepository extends JpaRepository<TopSalesCustomer, Long> {
}