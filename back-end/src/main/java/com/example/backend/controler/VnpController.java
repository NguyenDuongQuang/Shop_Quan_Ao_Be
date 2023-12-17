package com.example.backend.controler;

import com.example.backend.entity.Orders;
import com.example.backend.service.VnpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin("*")
@RequestMapping("/public/payment")
public class VnpController {

    @Autowired
    VnpService vnpayService;

    Orders dto;
    @PostMapping("/create")
    public ResponseEntity<?> createUrl(@RequestBody Orders hoaDonDTO) {

            dto = hoaDonDTO;
            return vnpayService.createPayment(hoaDonDTO);
    }

}
