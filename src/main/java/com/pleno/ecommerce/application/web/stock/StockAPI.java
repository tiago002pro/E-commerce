package com.pleno.ecommerce.application.web.stock;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/api/v1/stock", produces = MediaType.APPLICATION_JSON_VALUE)
public interface StockAPI {
}
