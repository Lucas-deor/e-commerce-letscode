package com.letscode.orderapi.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "user-service")
public interface UserReactiveFeignClient {

    @GetMapping("/user/{userId}")
    Mono<String> getProduct(@PathVariable("userId") Long productId);
}
