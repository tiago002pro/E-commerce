package com.pleno.ecommerce.infrasctructure.repository.payment;

import com.pleno.ecommerce.domain.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentJPARepository extends JpaRepository<Payment, UUID> {
}
