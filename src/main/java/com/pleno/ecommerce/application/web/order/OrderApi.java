package com.pleno.ecommerce.application.web.order;

import com.pleno.ecommerce.domain.model.Order;
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
    ResponseEntity<Order> create(@RequestBody Order request);

    @GetMapping
    ResponseEntity<List<Order>> getAll();
}
