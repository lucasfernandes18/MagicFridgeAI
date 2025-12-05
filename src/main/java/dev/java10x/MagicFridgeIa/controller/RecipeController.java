package dev.java10x.MagicFridgeIa.controller;

import dev.java10x.MagicFridgeIa.service.Gemini;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")


public class RecipeController {
   private final Gemini geminiService;

@GetMapping("/response")
    public Mono<ResponseEntity<String>> generateRecipe(){
    return geminiService.generateRecipe()

}



}
