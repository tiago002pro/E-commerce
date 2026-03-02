package com.pleno.ecommerce.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Product product;

    @Column(name = "stock")
    private Integer stock;
}

