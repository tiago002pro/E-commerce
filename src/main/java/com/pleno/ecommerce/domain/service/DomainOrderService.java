package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.application.service.ProductService;
import com.pleno.ecommerce.domain.exception.EmptyOrderException;
import com.pleno.ecommerce.domain.exception.NotFoundException;
import com.pleno.ecommerce.domain.model.Email;
import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.infrasctructure.mapper.OrderMapper;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    private final OrderMapper orderMapper;

    @Override
    public Order findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido", id));
    }

    @Transactional
    @Override
    public OrderResponse newOrder(NewOrderRequest request) {
        validateOrderItems(request.items());

        var email = new Email(request.customerEmail());
        var order = new Order(email);

        request.items().forEach(item -> {
            var product = productService.findById(item.productId());
            order.addItem(product, item.quantity());
        });

        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Transactional
    @Override
    public OrderResponse addItem(UUID id, NewOrderItemRequest itemRequest) {
        var order = findById(id);
        var product = productService.findById(itemRequest.productId());

        order.addItem(product, itemRequest.quantity());

        return orderMapper.toResponse(orderRepository.save(order));
    }

    private void validateOrderItems(List<NewOrderItemRequest> items) {
        if (items == null || items.isEmpty()) throw new EmptyOrderException();
    }
}
