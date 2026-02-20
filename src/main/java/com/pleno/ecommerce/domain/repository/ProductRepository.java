package com.pleno.ecommerce.domain.repository;

import com.pleno.ecommerce.domain.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Product create(Product request);

    List<Product> getAll();

    Optional<Product> findById(UUID id);
}
