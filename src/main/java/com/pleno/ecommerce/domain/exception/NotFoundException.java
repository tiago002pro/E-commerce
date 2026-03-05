package com.pleno.ecommerce.domain.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String item, UUID id) {
        super(item + " não encontrado: " + id);
    }
}
