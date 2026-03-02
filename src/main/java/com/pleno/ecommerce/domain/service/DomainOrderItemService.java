package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.dto.request.NewOrderItemRequest;
import com.pleno.ecommerce.application.service.OrderItemService;
import com.pleno.ecommerce.application.service.ProductService;
import com.pleno.ecommerce.domain.model.OrderItem;
import com.pleno.ecommerce.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class DomainOrderItemService implements OrderItemService {

    private final ProductService productService;

    @Override
    public OrderItem create(NewOrderItemRequest request) {
        Product product = productService.findById(request.productId());

        var subtotal = product.getAmount().multiply(BigDecimal.valueOf(request.quantity()));

        return new OrderItem(request.quantity(), product.getAmount(), subtotal, product);
    }
}
