package com.letscode.orderapi.gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "product-service")
public interface ProductReactiveFeignClient {

    @GetMapping("/product/{productId}")
    Mono<String> getProduct(@PathVariable("productId") Long productId);
}
