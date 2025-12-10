package dev.java10x.MagicFridgeIa.controller;

import dev.java10x.MagicFridgeIa.service.FoodDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import dev.java10x.MagicFridgeIa.model.FoodItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import dev.java10x.MagicFridgeIa.service.FoodItemService;

import java.util.List;

@RestController
@RequestMapping("/food")
@RequiredArgsConstructor // Cria construtor apenas para campos 'final'


public class FoodItemController {

    private final FoodItemService foodItemService;

    @PostMapping("/criar")
    public ResponseEntity<FoodDTO> criar(@RequestBody FoodDTO foodDTO) {
        FoodDTO save = foodItemService.salvar(foodDTO);
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

        @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarItem (@PathVariable Long id){
       foodItemService.deletar(id);
        return ResponseEntity.noContent().build();
        }

        @PutMapping("/atualizar/{id}")
    public ResponseEntity<FoodItem> atualizarItem(@PathVariable Long id, @RequestBody FoodItem atualizacao){
       FoodItem atualizado = foodItemService.atualizar(id, atualizacao);
        return ResponseEntity.ok(atualizado);
        }




    }


