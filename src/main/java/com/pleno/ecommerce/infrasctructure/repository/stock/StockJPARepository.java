package com.pleno.ecommerce.infrasctructure.repository.stock;

import com.pleno.ecommerce.domain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockJPARepository extends JpaRepository<Stock, UUID> {
}
