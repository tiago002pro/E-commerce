package com.pleno.ecommerce.application.service;

import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.domain.model.Order;

import java.util.List;

public interface OrderService {
    Order newOrder(NewOrderRequest request);

    List<Order> getAll();
}
