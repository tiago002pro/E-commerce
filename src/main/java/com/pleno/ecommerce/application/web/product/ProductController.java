package com.pleno.ecommerce.application.web.product;

import com.pleno.ecommerce.application.service.ProductService;
import com.pleno.ecommerce.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductAPI {

    private final ProductService service;

    @Override
    public ResponseEntity<Product> create(Product request) {
        return ResponseEntity.ok(service.create(request));
    }

    @Override
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
