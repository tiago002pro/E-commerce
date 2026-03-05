package com.pleno.ecommerce.application.dto.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        String customerEmail,
        BigDecimal totalAmount,
        List<OrderItemResponse> items
) {}
