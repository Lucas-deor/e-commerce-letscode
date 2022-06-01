package com.letscode.orderapi.handler;

import com.letscode.orderapi.domain.OrderEntity;
import com.letscode.orderapi.gateway.UserGateway;
import com.letscode.orderapi.repository.OrderRepository;
import com.letscode.orderapi.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class OrderHandler {

    private final OrderRepository orderRepository;
    private final OrderService orderService;
    private final UserGateway userGateway;

    public OrderHandler(OrderRepository orderRepository, OrderService orderService, UserGateway userGateway) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
        this.userGateway = userGateway;
    }

    public Mono<ServerResponse> createOrder(ServerRequest request) {
        return request.bodyToMono(OrderEntity.class)
                .flatMap(orderService::newOrder)
                .flatMap(o -> orderRepository.save(o))
                .flatMap(order -> ServerResponse
                        .created(URI.create(String.format("/order/%s", order.getId())))
                        .bodyValue(order))
                .switchIfEmpty(ServerResponse.unprocessableEntity().bodyValue("Could not find a valid user, verify."));
    }

//    public Mono<OrderEntity> getOrderById(@PathVariable String id) {
//        orderRepository.findById() request.bodyToMono(OrderEntity.class).map(orderRepository.findById());
//    }

    public Mono<ServerResponse> getOrderById(ServerRequest request) {
        return orderService
                .getOrder(request.pathVariable("orderId"))
                .flatMap(order -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(order, OrderEntity.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
