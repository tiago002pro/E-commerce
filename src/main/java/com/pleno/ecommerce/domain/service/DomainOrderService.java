package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.application.service.OrderService;
import com.pleno.ecommerce.application.service.ProductService;
import com.pleno.ecommerce.domain.exception.EmptyOrderException;
import com.pleno.ecommerce.domain.model.Order;
import com.pleno.ecommerce.domain.model.Product;
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

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order newOrder(NewOrderRequest request) {
        validateItems(request.productsId());

        List<Product> products = request.productsId().stream().map(productService::findById).toList();

        BigDecimal totalAmount = products.stream().map(Product::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        Order order = new Order(request.customerEmail(), totalAmount, products);

        return orderRepository.save(order);
    }

    private void validateItems(List<UUID> productsId) {
        if (productsId == null || productsId.isEmpty()) throw new EmptyOrderException();
    }
}
