package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.dto.response.OrderResponse;
import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.application.service.ProductService;
import com.pleno.ecommerce.domain.exception.EmptyOrderException;
import com.pleno.ecommerce.domain.exception.NotFoundException;
import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.domain.model.OrderItem;
import com.pleno.ecommerce.domain.model.mapper.OrderMapper;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    private final OrderMapper orderMapper;

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order findById(UUID id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido", id));
    }

    @Override
    public OrderResponse newOrder(NewOrderRequest request) {
        validateItems(request.items());

        var order = new Order(request.customerEmail());
        var items = request.items().stream().map(this::createOrderItem).toList();

        items.forEach(order::addItem);

        order = orderRepository.save(order);

        return orderMapper.toResponse(order);
    }

    @Override
    public OrderResponse addItem(UUID id, NewOrderItemRequest itemRequest) {
        var order = findById(id);
        var orderItem = createOrderItem(itemRequest);

        order.addItem(orderItem);
        order = orderRepository.save(order);
        return orderMapper.toResponse(order);
    }

    private void validateItems(List<NewOrderItemRequest> items) {
        if (items == null || items.isEmpty()) throw new EmptyOrderException();
    }

    private OrderItem createOrderItem(NewOrderItemRequest itemRequest) {
        var product = productService.findById(itemRequest.productId());
        var subtotal = product.getAmount().multiply(BigDecimal.valueOf(itemRequest.quantity()));

        return new OrderItem(
                itemRequest.quantity(),
                product.getAmount(),
                subtotal,
                product
        );
    }
}
