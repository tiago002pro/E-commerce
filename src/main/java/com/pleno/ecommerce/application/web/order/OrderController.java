package com.pleno.ecommerce.application.web.order;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.domain.model.Order;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Override
    public ResponseEntity<OrderResponse> newOrder(@Valid NewOrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.newOrder(request));
    }

    @Override
    public ResponseEntity<OrderResponse> addItem(UUID id, NewOrderItemRequest itemRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addItem(id, itemRequest));
    }

    @Override
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }
}
