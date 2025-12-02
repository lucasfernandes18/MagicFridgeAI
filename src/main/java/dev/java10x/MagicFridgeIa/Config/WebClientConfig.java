package dev.java10x.MagicFridgeIa.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("$chatGptApi.url:https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent")
    private String chatGptApiUrl;


    @Bean
    public WebClient webClient (WebClient.Builder bilder) {
        return bilder.baseUrl(chatGptApiUrl).build();
    }

}
