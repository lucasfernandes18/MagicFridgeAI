package dev.java10x.MagicFridgeIa.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/*
* curl "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent" \
  -H "x-goog-api-key: $GEMINI_API_KEY" \
  -H 'Content-Type: application/json' \
  -X POST \
  -d '{
    "contents": [
      {
        "modelVersion": "gemini-2.5-flash"
        "parts": [
          {
            "text": "Explain how AI works in a single paragraph."
          }
        ]
      }
    ]
  }'*/


@Service
@RequiredArgsConstructor
public class Gemini {

    private final WebClient webClient;
    private String apiKey = System.getenv("API.KEY");


    public Mono<String> generateRecipe(){
        String prompt = "me sugira uma receita simples com ingredientes comuns";
        Map<String, Object> contentPart = Map.of("text", prompt);
        Map<String, Object> contentBlock = Map.of("parts", List.of(contentPart));

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(contentBlock)
                // modelVersion não é mais estritamente necessário no corpo,
                // pois o modelo é especificado na URL, mas você pode adicioná-lo
        );
        // ---------------------------------------------

        return webClient.post()
                // 1. URL correta, incluindo o modelo e a API Key
                .uri(uriBuilder -> uriBuilder
                        .path("/v1beta/models/gemini-2.5-flash:generateContent")
                        .queryParam("key", apiKey) // Adiciona a chave como query parameter
                        .build())
                .bodyValue(requestBody) // Adiciona o corpo (payload)
                .retrieve()
                .bodyToMono(String.class); // Recebe a resposta como String (JSON)
        // Nota: Você pode querer mapear esta String para uma classe de resposta
    }
}



