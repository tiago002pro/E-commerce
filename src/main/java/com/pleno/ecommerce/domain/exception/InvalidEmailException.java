package com.pleno.ecommerce.domain.exception;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException() {
    super("E-mail inválido.");
    }
}
