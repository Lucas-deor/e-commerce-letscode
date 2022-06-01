package com.letscode.productapi.controller;

import com.letscode.productapi.domain.ProductEntity;
import com.letscode.productapi.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ProductEntity> addProduct(@RequestBody ProductEntity productEntity) {
        ProductEntity product = this.productRepository.save(productEntity);

        return ResponseEntity.created(URI.create(String.format("/product/%s", product.getId()))).body(product);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable String id) {
        Optional<ProductEntity> product = this.productRepository.findById(id);

        if(product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(product.get());
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable String id) {
        Optional<ProductEntity> product = this.productRepository.findById(id);

        if(product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        this.productRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/alter/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String id, @RequestBody ProductEntity productDetails) {
        Optional<ProductEntity> product = this.productRepository.findById(id);

        if(product.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        product.get().setName(productDetails.getName());
        product.get().setPrice(productDetails.getPrice());

        this.productRepository.save(product.get());

        return ResponseEntity.ok(product.get());
    }

}
