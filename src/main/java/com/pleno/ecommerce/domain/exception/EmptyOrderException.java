package com.pleno.ecommerce.domain.exception;

public class EmptyOrderException extends RuntimeException {
    public EmptyOrderException() {
        super("Nenhum item foi adicionado ao pedido.");
    }
}
