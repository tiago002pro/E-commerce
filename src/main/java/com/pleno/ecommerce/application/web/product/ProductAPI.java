package com.pleno.ecommerce.application.web.product;

import com.pleno.ecommerce.domain.model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/api/v1/product", produces = MediaType.APPLICATION_JSON_VALUE)
public interface ProductAPI {

    @PostMapping
    ResponseEntity<Product> create(@RequestBody Product request);

    @GetMapping
    ResponseEntity<List<Product>> getAll();
}
