package com.pleno.ecommerce.domain.service;

import com.pleno.ecommerce.application.service.ProductService;
import com.pleno.ecommerce.domain.exception.ProductNotFoundException;
import com.pleno.ecommerce.domain.model.Product;
import com.pleno.ecommerce.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainProductService implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product request) {
        return productRepository.create(request);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
