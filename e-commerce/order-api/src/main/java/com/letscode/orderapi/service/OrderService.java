package com.letscode.orderapi.service;

import com.letscode.orderapi.domain.OrderEntity;
import com.letscode.orderapi.gateway.ProductGateway;
import com.letscode.orderapi.gateway.UserGateway;
import com.letscode.orderapi.repository.OrderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final ProductGateway productGateway;
    private final UserGateway userGateway;
    private final OrderRepository orderRepository;

    public OrderService(ProductGateway productGateway, UserGateway userGateway, OrderRepository orderRepository) {
        this.productGateway = productGateway;
        this.userGateway = userGateway;
        this.orderRepository = orderRepository;
    }

    public Mono<OrderEntity> newOrder(OrderEntity o) {
        return Mono.just(o).flatMap(order -> userGateway.getUser(order.getUserId())).map(t -> o);
    }

    public Mono<OrderEntity> createOrder(OrderEntity order) {
        return orderRepository.save(order);
    }

    public Mono<OrderEntity> getOrder(String id) {
        return orderRepository.findById(id);
    }

//        return Mono.zip(
//                Mono.just(o).flatMap(order -> productGateway.getProduct(order.getProductId())),
//                Mono.just(o).flatMap(order -> userGateway.getUser(order.getUserId())),
//        ).map(t -> o);

}
