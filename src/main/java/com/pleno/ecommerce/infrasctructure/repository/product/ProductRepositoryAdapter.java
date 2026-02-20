package com.pleno.ecommerce.infrasctructure.repository.product;

import com.pleno.ecommerce.domain.model.Product;
import com.pleno.ecommerce.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductJPARepository productJPARepository;

    @Override
    public Product create(Product request) {
        return productJPARepository.save(request);
    }

    @Override
    public List<Product> getAll() {
        return productJPARepository.findAll();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productJPARepository.findById(id);
    }
}
