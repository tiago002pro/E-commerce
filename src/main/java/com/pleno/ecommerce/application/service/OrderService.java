package com.pleno.ecommerce.application.service;

import com.pleno.ecommerce.domain.model.Order;

import java.util.List;

public interface OrderService {
    Order create(Order request);

    List<Order> getAll();
}
