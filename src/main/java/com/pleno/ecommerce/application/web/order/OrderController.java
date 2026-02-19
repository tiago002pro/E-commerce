package com.pleno.ecommerce.application.web.order;

import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.domain.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> create(Order request) {
        return ResponseEntity.ok(orderService.create(request));
    }

    @Override
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}
