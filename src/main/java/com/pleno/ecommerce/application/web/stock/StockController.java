package com.pleno.ecommerce.application.web.stock;

import com.pleno.ecommerce.application.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StockController implements StockAPI {

    private final StockService stockService;
}
