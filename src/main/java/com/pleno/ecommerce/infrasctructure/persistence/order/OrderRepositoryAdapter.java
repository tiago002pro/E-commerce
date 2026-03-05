package com.pleno.ecommerce.infrasctructure.persistence.order;

import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJPARepository orderJPARepository;

    @Override
    public Order save(Order request) {
        return orderJPARepository.save(request);
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return orderJPARepository.findById(id);
    }
}
