package com.hhx.web_code.resilience4j.service;

import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

/**
 * @author hhx
 * @date 2022/7/6
 * @note
 */
@Service
public class TimerServiceImpl {
    private final RestTemplate restTemplate = new RestTemplate();

    private final String ratingService = "http://localhost:8080/{timer}";

    @TimeLimiter(name = "backendB", fallbackMethod = "getDefault")
    public CompletionStage<String> getDemo(String timer) {
        Supplier<String> temp = () -> this.restTemplate.
                getForEntity(this.ratingService + "/" + timer, String.class).getBody();
        return CompletableFuture.supplyAsync(temp);
    }

    private CompletionStage<String> getDefault(String timer, Throwable throwable) {
        return CompletableFuture.supplyAsync(() -> "default");
    }

}
