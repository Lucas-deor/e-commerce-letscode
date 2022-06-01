package com.letscode.orderapi.config;

import com.letscode.orderapi.handler.OrderHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(OrderHandler orderHandler) {
        return RouterFunctions
                .route(RequestPredicates
                        .POST("/order/add")
                        .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), orderHandler::createOrder)
                .andRoute(RequestPredicates
                        .GET("/order/{orderId}")
                        .and(RequestPredicates.contentType(MediaType.APPLICATION_JSON)), orderHandler::getOrderById);
    }

}
