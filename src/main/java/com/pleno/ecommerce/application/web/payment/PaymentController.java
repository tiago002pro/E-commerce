package com.pleno.ecommerce.application.web.payment;

import com.pleno.ecommerce.application.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PaymentController implements PaymentAPI {

    private final PaymentService paymentService;
}
