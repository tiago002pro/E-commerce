package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order create(Order request) {
        return orderRepository.create(request);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
}
