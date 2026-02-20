package com.pleno.ecommerce.application.web.order;

import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.domain.model.Order;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api/v1/order", produces = MediaType.APPLICATION_JSON_VALUE)
public interface OrderApi {

    @PostMapping
    ResponseEntity<Order> newOrder(@RequestBody @Valid NewOrderRequest request);

    @GetMapping
    ResponseEntity<List<Order>> getAll();
}
