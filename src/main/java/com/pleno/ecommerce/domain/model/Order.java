package com.pleno.ecommerce.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Embedded
    private Email customerEmail;

    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    public Order(Email customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void addItem(OrderItem item) {
        item.setOrder(this);
        this.items.add(item);
        recalculateTotal();
    }

    public void addItem(Product product, Integer quantity) {

        var unitPrice = product.getAmount();
        var subtotal = unitPrice.multiply(BigDecimal.valueOf(quantity));

        var item = new OrderItem(this, product, quantity, unitPrice, subtotal);

        items.add(item);

        recalculateTotal();
    }

    private void recalculateTotal() {
        this.totalAmount = items.stream()
                .map(OrderItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
