package dev.java10x.MagicFridgeIa.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${GeminiApi.url:https://generativelanguage.googleapis.com}")
    private String GeminiApi;

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }


    @Bean
    public WebClient webClient (WebClient.Builder builder) {
        return builder.baseUrl(GeminiApi).build();
    }

}
