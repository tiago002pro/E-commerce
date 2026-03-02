package com.pleno.ecommerce.infrasctructure.repository.orderitem;

import com.pleno.ecommerce.domain.repository.OrderItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderItemRepositoryAdapter implements OrderItemRepository {

    private final OrderItemJPARepository orderItemJPARepository;
}
