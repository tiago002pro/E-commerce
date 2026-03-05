package com.pleno.ecommerce.infrasctructure.persistence.stock;

import com.pleno.ecommerce.domain.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockRepositoryAdapter implements StockRepository {

    private final StockJPARepository stockJPARepository;
}
