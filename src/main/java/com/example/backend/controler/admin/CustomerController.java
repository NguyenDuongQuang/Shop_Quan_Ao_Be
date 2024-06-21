package com.example.backend.controler.admin;

import com.example.backend.dto.CustomerDto;
import com.example.backend.dto.UpdateCustomerDto;
import com.example.backend.entity.Customer;
import com.example.backend.model.CustomerSearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@CrossOrigin("*")
@Validated
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/get-list")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerDto customer) throws Exception {
        return ResponseEntity.ok().body(new ResponseChangeDataModel(customerService.createCustomer(customer), HttpStatus.OK.value()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable(value = "id") Long id, @RequestBody UpdateCustomerDto customer) {
        return ResponseEntity.ok().body(new ResponseChangeDataModel(customerService.updateCustomer(customer, id), HttpStatus.OK.value()));
    }

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable(name = "id") @Positive Long id) {
        return ResponseEntity.ok().body(customerService.getCustomer(id));

    }

    @PostMapping("/get-list")
    public ResponseEntity<?> getCustomers(@RequestBody CustomerSearchCriteriaModel customerSearchCriteriaModel) {
        Page<Customer> pageElements = customerService.getCustomers(customerSearchCriteriaModel);
        return ResponseEntity.ok().body(new ResponseGetDataModel(pageElements.getContent(), pageElements.getNumber(), pageElements.getTotalElements(), pageElements.getTotalPages()));
    }
}