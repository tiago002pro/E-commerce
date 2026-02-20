package com.pleno.ecommerce.infrasctructure.repository.payment;

import com.pleno.ecommerce.domain.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PaymentRepositoryAdapter implements PaymentRepository {

    private final PaymentJPARepository paymentJPARepository;
}
