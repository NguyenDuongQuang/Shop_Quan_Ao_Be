package com.example.backend.controler.admin;

import com.example.backend.dto.UpdateOrdersDto;
import com.example.backend.entity.Orders;
import com.example.backend.model.OrderSearchCriteriaModel;
import com.example.backend.model.ResponseChangeDataModel;
import com.example.backend.model.ResponseGetDataModel;
import com.example.backend.service.view.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@Validated
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/get-detail/{id}")
    public ResponseEntity<?> getOrderDetail(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.getOrdersById(id));
    }

    @PostMapping("/get-list")
    public ResponseEntity<?> getOrders(@RequestBody OrderSearchCriteriaModel model) {
        Page<Orders> pageElements = orderService.getOrders(model);
        return ResponseEntity.ok().body(
                new ResponseGetDataModel(pageElements.getContent(),
                        pageElements.getNumber(), pageElements.getTotalElements(),
                        pageElements.getTotalPages()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateOrders(@RequestBody @Valid UpdateOrdersDto updateOrdersDto, @PathVariable Long id) {
        return ResponseEntity.ok().body(
                new ResponseChangeDataModel(orderService.updateOrdersById(updateOrdersDto, id), HttpStatus.OK.value()));
    }

}
