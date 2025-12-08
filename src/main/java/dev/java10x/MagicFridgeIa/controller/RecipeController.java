package dev.java10x.MagicFridgeIa.controller;

import dev.java10x.MagicFridgeIa.model.FoodItem;
import dev.java10x.MagicFridgeIa.service.FoodItemService;
import dev.java10x.MagicFridgeIa.service.Gemini;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")


public class RecipeController {
   private final Gemini geminiService;

   private final FoodItemService service;

@GetMapping("/response")
    public Mono<ResponseEntity<String>> generateRecipe(){
    List<FoodItem> foodItemList = service.listar();
    return geminiService.generateRecipe(foodItemList)
            .map(recipe -> ResponseEntity.ok(recipe))
            .defaultIfEmpty(ResponseEntity.noContent().build());

}



}
