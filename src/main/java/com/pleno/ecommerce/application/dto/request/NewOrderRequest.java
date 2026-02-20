package com.pleno.ecommerce.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record NewOrderRequest(

        @Email(message = "E-mail inválido")
        @NotNull
        String customerEmail,

        @NotEmpty(message = "A lista de produtos não pode estar vazia")
        List<UUID> productsId
) {}
