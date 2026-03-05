package com.pleno.ecommerce.domain.repository;

import com.pleno.ecommerce.domain.model.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {
    Order save(Order request);
    Optional<Order> findById(UUID id);
}
