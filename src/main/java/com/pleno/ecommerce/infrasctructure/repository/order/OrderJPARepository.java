package com.pleno.ecommerce.infrasctructure.repository.order;

import com.pleno.ecommerce.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderJPARepository extends JpaRepository<Order, UUID> {
}
