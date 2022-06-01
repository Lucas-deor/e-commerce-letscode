package com.letscode.orderapi.gateway;

import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserGateway {

//    @Value("${user.base.url}")
//    private String baseUrl;

    private final UserReactiveFeignClient userReactiveFeignClient;

    public Mono<String> getUser(Long userId) {
        return userReactiveFeignClient.getProduct(userId)
                .onErrorResume(FeignException.NotFound.class, error -> Mono.empty());
    }
}
