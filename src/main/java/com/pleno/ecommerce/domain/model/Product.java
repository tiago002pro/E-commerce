package com.pleno.ecommerce.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    UUID uid;

    @Column(name = "name")
    String name;

    @Column(name = "amount")
    BigDecimal amount;
}
