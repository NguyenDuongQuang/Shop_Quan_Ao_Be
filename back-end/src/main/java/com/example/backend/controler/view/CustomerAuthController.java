package com.example.backend.controler.view;

import com.example.backend.config.Constants;
import com.example.backend.dto.CustomerDto;
import com.example.backend.entity.Customer;
import com.example.backend.model.CustomerAuthenModel;
import com.example.backend.model.CustomerRegisterModel;
import com.example.backend.model.LoginGoogleModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Validated
@RequestMapping("/public")
public class CustomerAuthController {
    private final CustomerService customerService;

    @PostMapping("/customer/login")
    public ResponseEntity<?> login(@RequestBody @Valid CustomerAuthenModel request) throws Exception {
        System.out.println("login");

        Customer customer = customerService.getByEmailCustomer(request.getEmail());

        System.out.println(customer);
        System.out.println(request.getPassword());
        if (!customer.getPassword().equals(request.getPassword())) {
            throw new Exception(Constants.USERNAME_OR_PASSWORD_NOT_MATCH);
        }
        if (customer.getStatus() == 0) {
            throw new Exception(Constants.USER_LOCKED);
        }
        return ResponseEntity.ok().body(new ResponseChangeDataModel(customer, HttpStatus.OK.value()));

    }

    @PostMapping("/customer/login-google")
    public ResponseEntity<?> loginGoogle(@RequestBody @Valid LoginGoogleModel request) throws Exception {
        System.out.println(request);
        System.out.println("login");

        Customer customer = customerService.getByEmailCustomer(request.getEmail());
        CustomerDto customerDto = new CustomerDto();

        if (customer == null) {
            customerDto.setEmail(request.getEmail());
            customerDto.setName(request.getName());
            customerDto.setPassword(request.getPassword());
            customer = customerService.createCustomer(customerDto);
        }
        if (customer.getStatus() == 0) {
            throw new Exception(Constants.USER_LOCKED);
        }
        return ResponseEntity.ok().body(new ResponseChangeDataModel(customer, HttpStatus.OK.value()));

    }


    @PostMapping("/customer/register")
    public ResponseEntity<?> loginGoogle(@RequestBody @Valid CustomerRegisterModel request) throws Exception {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(request.getEmail());
        customerDto.setPassword(request.getPassword());
        customerDto.setName(request.getName());
        customerDto.setPhone(request.getPhone());
    
        Customer customer = customerService.createCustomer(customerDto);
        return ResponseEntity.ok().body(new ResponseChangeDataModel(customer, HttpStatus.OK.value()));
    }

}
