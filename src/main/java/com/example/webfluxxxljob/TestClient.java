package com.example.webfluxxxljob;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TestClient {

    private final WebClient webClient;

    public TestClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://httpbin.org")
                .build();
    }

    public Mono<String> get() {
        log.info("Accessing https://httpbin.org/json");
        return webClient.get().uri("/json")
                .retrieve()
                .bodyToMono(String.class);
    }
}
