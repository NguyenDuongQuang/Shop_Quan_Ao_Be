package com.example.backend.service;
import com.example.backend.dto.CustomerDto;
import com.example.backend.dto.UpdateCustomerDto;
import com.example.backend.entity.Customer;
import com.example.backend.model.CustomerSearchCriteriaModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(Long id);
    Customer getByEmailCustomer(String getEmail);
    Customer createCustomer( CustomerDto customer) throws Exception;
    Customer updateCustomer(UpdateCustomerDto customer, Long id);
    List<Customer> getAllCustomers();
    Page<Customer> getCustomers(CustomerSearchCriteriaModel customerSearchCriteriaModel);
    Customer getUserProfileByUserId(Long userId);
    Customer updateProfileByUserId(UpdateCustomerDto customerDto, Long userId) throws Exception;
}


