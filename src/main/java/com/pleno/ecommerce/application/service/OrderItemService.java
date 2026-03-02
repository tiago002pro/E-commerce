package com.pleno.ecommerce.application.service;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.domain.model.OrderItem;

public interface OrderItemService {
    OrderItem create(NewOrderItemRequest request);
}
