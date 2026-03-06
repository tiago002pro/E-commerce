package com.pleno.ecommerce.infrasctructure.mapper;

import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.infrasctructure.event.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderEventMapper {

    public OrderCreatedEvent toEvent(Order order) {
        return new OrderCreatedEvent(order.getId(), order.getCustomerEmail().getValue(), order.getTotalAmount());
    }
}
