package com.example.backend.controler;

import com.example.backend.config.VnpConfig;
import com.example.backend.entity.Orders;
import com.example.backend.repository.OrdersRepository;
import com.example.backend.service.VnpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController()
@CrossOrigin("*")
@RequestMapping("/public/payment")
public class VnpController {

    @Autowired
    VnpService vnpayService;

    @Autowired
    public OrdersRepository ordersRepository;
    Orders dto;
    @PostMapping("/create")
    public ResponseEntity<?> createUrl(@RequestBody Orders hoaDonDTO) {
        dto=hoaDonDTO;
        return vnpayService.createPayment(hoaDonDTO);
    }
    @GetMapping("/checkPay")
    public RedirectView check(@RequestParam("vnp_ResponseCode") String responseCode,
                              @RequestParam("orderID") Long orderID){
        if ("00".equals(responseCode)){
            Orders orders = ordersRepository.getReferenceById(orderID);
            orders.setPaymentStatus(true);
            ordersRepository.save(orders);
            return new RedirectView(VnpConfig.urlSuccess);
        }
        return new RedirectView(VnpConfig.urlFail);
    }


}
