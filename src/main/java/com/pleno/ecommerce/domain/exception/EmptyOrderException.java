package com.pleno.ecommerce.domain.exception;

public class EmptyOrderException extends RuntimeException {
    public EmptyOrderException() {
        super("Nenhum produto foi adicionado ao pedido.");
    }
}
