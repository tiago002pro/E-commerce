package com.pleno.ecommerce.infrasctructure.repository.order;

import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJPARepository orderJPARepository;

    @Override
    public Order save(Order request) {
        return orderJPARepository.save(request);
    }

    @Override
    public List<Order> getAll() {
        return orderJPARepository.findAll();
    }
}
