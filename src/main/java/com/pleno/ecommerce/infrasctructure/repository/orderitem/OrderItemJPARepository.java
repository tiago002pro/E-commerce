package com.pleno.ecommerce.infrasctructure.repository.orderitem;

import com.pleno.ecommerce.domain.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderItemJPARepository extends JpaRepository<OrderItem, UUID> {
}
