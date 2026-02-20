package com.pleno.ecommerce.application.web.order;

import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.domain.model.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<Order> newOrder(@Valid NewOrderRequest request) {
        return ResponseEntity.ok(orderService.newOrder(request));
    }

    @Override
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}
