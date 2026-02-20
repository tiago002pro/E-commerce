package com.pleno.ecommerce.application.service;

import com.pleno.ecommerce.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    Product create(Product request);

    List<Product> getAll();

    Product findById(UUID id);
}
