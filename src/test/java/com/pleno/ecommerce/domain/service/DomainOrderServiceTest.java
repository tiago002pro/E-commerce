package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.dto.request.NewOrderRequest;
import com.pleno.ecommerce.domain.model.Product;
import com.pleno.ecommerce.domain.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DomainOrderServiceTest {

    @Mock private OrderRepository orderRepository;
    @Mock private DomainProductService productService;

    @InjectMocks private DomainOrderService orderService;


    @Test
    void newOrderTest() {
        var product = new Product(UUID.randomUUID(), "Iphone", new BigDecimal("10"));

        var request = new NewOrderRequest("email@gmail.com", List.of(product.getId()));

        when(productService.findById(any())).thenReturn(product);

        when(orderRepository.save(any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        var response = orderService.newOrder(request);

        assertNotNull(response);
        assertEquals(response.getTotalAmount(), product.getAmount());
        assertEquals(1, response.getItems().size());
    }
}
