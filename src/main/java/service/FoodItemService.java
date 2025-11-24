package service;

import lombok.Data;
import model.FoodItem;
import org.springframework.stereotype.Service;
import repository.FoodItemRepository;

import java.util.List;

@Data
@Service
public class FoodItemService {
private FoodItemRepository repository;

public FoodItem salvar (FoodItem foodItem){
    return repository.save(foodItem);
}

public List <FoodItem> listar() {
    return repository.findAll();
}







}
