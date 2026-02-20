package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.service.PaymentService;
import com.pleno.ecommerce.domain.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DomainPaymentService implements PaymentService {

    private final PaymentRepository paymentRepository;
}
