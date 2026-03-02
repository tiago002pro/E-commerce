package com.pleno.ecommerce.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record NewOrderRequest(

        @Email(message = "E-mail inválido")
        @NotNull
        String customerEmail,

        @NotEmpty(message = "A lista de itens não pode estar vazia")
        List<NewOrderItemRequest> items
) {}
