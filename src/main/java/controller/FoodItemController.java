package controller;

import lombok.Data;
import model.FoodItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import service.FoodItemService;

@RestController
@RequestMapping("/food")
@Data
public class FoodItemController {

    private FoodItemService foodItemService;

    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem){
      FoodItem save = foodItemService.salvar(foodItem);
     return ResponseEntity.ok(save);

    }


}
