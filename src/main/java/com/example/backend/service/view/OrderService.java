package com.example.backend.service.view;

import com.example.backend.dto.UpdateOrdersDto;
import com.example.backend.dto.sale.OrdersSaleDto;
import com.example.backend.entity.Orders;
import com.example.backend.model.OrderSearchCriteriaModel;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    Page<Orders> getOrders(OrderSearchCriteriaModel model);
    ResponseEntity<?> payCart(OrdersSaleDto ordersSaleDto);
    ResponseEntity<?> cancelOrder(Long id);
    Orders getOrdersById(Long id);
    Orders updateOrdersById(UpdateOrdersDto updateOrdersDto, Long id);
    Orders cancelOrdersById(UpdateOrdersDto updateOrdersDto, Long id);
    List<Orders> getSaleOrdersByEmail(String email);

}
