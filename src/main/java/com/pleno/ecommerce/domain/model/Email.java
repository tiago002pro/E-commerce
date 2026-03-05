package com.pleno.ecommerce.domain.model;

import com.pleno.ecommerce.domain.exception.InvalidEmailException;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Email {

    @Column(name = "customer_email")
    private String value;

    protected Email() {}

    public Email(String value) {
        if (!value.contains("@")) {
            throw new InvalidEmailException();
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
