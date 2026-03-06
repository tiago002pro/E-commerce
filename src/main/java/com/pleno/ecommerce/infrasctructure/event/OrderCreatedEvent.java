package com.pleno.ecommerce.infrasctructure.event;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        String customerEmail,
        BigDecimal total
) {}
