package dev.java10x.MagicFridgeIa.service;

import dev.java10x.MagicFridgeIa.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {
    FoodItem foodItem;

    public FoodItem map(FoodDTO foodDTO){
        FoodItem foodItem = new FoodItem();

        foodItem.setId(foodDTO.getId());
        foodItem.setNome(foodDTO.getNome());
        foodItem.setCategoria(foodDTO.getCategoria());
        foodItem.setValidade(foodDTO.getValidade());
        foodItem.setQuantidade(foodItem.getQuantidade());

        return foodItem;
    }

    public FoodDTO map(FoodItem foodItem){
        FoodDTO foodDTO = new FoodDTO();

        foodDTO.setId(foodItem.getId());
        foodDTO.setNome(foodItem.getNome());
        foodDTO.setCategoria(foodItem.getCategoria());
        foodDTO.setValidade(foodItem.getValidade());
        foodDTO.setQuantidade(foodItem.getQuantidade());

        return foodDTO;

    }
}
