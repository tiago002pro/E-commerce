package com.pleno.ecommerce.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    UUID uid;

    @Column(name = "customer_email")
    String customerEmail;

    @Column(name = "total_amount")
    BigDecimal totalAmount;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "tb_order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> items;
}
