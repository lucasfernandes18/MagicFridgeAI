package controller;

import lombok.Data;
import model.FoodItem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FoodItemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
@Data
public class FoodItemController {

    private FoodItemService foodItemService;

    @GetMapping("/criar")
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        FoodItem save = foodItemService.salvar(foodItem);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FoodItem>> listar (){
        List<FoodItem> listarComidas = foodItemService.listar();
        return ResponseEntity.ok(listarComidas);
    }

        @GetMapping("/listarId/{id}")
        public ResponseEntity<FoodItem> listarPorId(@PathVariable Long id) {
            return ResponseEntity.of(foodItemService.listarPorId(id));
        }

        @GetMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarItem (@PathVariable Long id){
       foodItemService.deletar(id);
        return ResponseEntity.noContent().build();
        }









        //listar por id
        //alterar
        //deletar




    }


