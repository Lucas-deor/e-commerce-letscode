package com.letscode.productapi.repository;

import com.letscode.productapi.domain.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
