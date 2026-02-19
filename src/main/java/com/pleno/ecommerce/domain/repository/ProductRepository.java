package com.pleno.ecommerce.domain.repository;

import com.pleno.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    Product create(Product request);

    List<Product> getAll();
}
