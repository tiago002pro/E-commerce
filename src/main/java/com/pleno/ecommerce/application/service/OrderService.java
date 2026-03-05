package com.pleno.ecommerce.application.service;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.domain.model.Order;

import java.util.UUID;

public interface OrderService {
    Order findById(UUID id);
    OrderResponse newOrder(NewOrderRequest request);
    OrderResponse addItem(UUID id, NewOrderItemRequest itemRequest);
}
