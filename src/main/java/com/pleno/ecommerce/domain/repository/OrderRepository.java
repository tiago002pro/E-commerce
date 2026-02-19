package com.pleno.ecommerce.domain.repository;

import com.pleno.ecommerce.domain.model.Order;

import java.util.List;

public interface OrderRepository {
    Order create(Order request);

    List<Order> getAll();
}
