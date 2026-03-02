package com.pleno.ecommerce.application.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record NewOrderItemRequest(@NotNull UUID productId, @NotNull Integer quantity) {
}
