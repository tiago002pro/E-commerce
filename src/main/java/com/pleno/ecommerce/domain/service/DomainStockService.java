package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.service.StockService;
import com.pleno.ecommerce.domain.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DomainStockService implements StockService {

    private final StockRepository stockRepository;
}
