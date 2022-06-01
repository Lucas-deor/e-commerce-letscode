package com.letscode.orderapi.repository;

import com.letscode.orderapi.domain.OrderEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<OrderEntity, String> {
}
