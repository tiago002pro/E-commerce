package com.pleno.ecommerce.application.web.payment;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/vi/payment", produces = MediaType.APPLICATION_JSON_VALUE)
public interface PaymentAPI {
}
