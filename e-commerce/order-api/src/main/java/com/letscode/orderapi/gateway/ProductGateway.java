package com.letscode.orderapi.gateway;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ProductGateway {

//    @Value("${product.base.url}")
//    private String baseUrl;

    private final ProductReactiveFeignClient productReactiveFeignClient;

    public Mono<String> getProduct(Long productId) {
        return productReactiveFeignClient.getProduct(productId)
                .onErrorResume(FeignException.NotFound.class, error -> Mono.empty());
    }
}
