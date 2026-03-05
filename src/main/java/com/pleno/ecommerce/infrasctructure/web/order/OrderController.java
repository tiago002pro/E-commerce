package com.pleno.ecommerce.infrasctructure.web.order;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.application.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
}
