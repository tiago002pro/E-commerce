package com.pleno.ecommerce.infrasctructure.repository.product;

import com.pleno.ecommerce.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductJPARepository extends JpaRepository<Product, UUID> {
}
