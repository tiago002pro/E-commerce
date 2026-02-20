package com.pleno.ecommerce.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToMany
    @JoinColumn(name = "order_id", nullable = false)
    private List<Order> orderList;

    @Column(name = "amount")
    private BigDecimal amount;
}
