package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.service.OrderItemService;
import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.domain.exception.EmptyOrderException;
import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.domain.model.OrderItem;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemService orderItemService;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order newOrder(NewOrderRequest request) {
        validateItems(request.items());

        Order order = new Order(request.customerEmail());

        List<OrderItem> items = request.items().stream().map(orderItemService::create).toList();

        items.forEach(order::addItem);

        return orderRepository.save(order);
    }

    private void validateItems(List<NewOrderItemRequest> items) {
        if (items == null || items.isEmpty()) throw new EmptyOrderException();
    }
}
