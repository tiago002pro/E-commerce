package com.pleno.ecommerce.application.web.order;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.domain.model.Order;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping(value = "/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
public interface OrderApi {

    @PostMapping
    ResponseEntity<OrderResponse> newOrder(@RequestBody @Valid NewOrderRequest request);

    @PutMapping("/{id}")
    ResponseEntity<OrderResponse> addItem(@PathVariable UUID id,
                                          @RequestBody @Valid NewOrderItemRequest itemRequest);

    @GetMapping
    ResponseEntity<List<Order>> getAll();
}
