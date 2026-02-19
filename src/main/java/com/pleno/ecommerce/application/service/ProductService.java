package com.pleno.ecommerce.application.service;

import com.pleno.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductService {
    Product create(Product request);

    List<Product> getAll();
}
