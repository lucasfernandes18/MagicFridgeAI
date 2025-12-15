package dev.java10x.MagicFridgeIa.controller;

import dev.java10x.MagicFridgeIa.model.FoodItem;
import dev.java10x.MagicFridgeIa.service.FoodDTO;
import dev.java10x.MagicFridgeIa.service.FoodItemService;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.math.raw.Mod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/food/ui")

public class FoodItemControllerUI {

    private final FoodItemService foodItemService;

    public void Home(){}


    @GetMapping("/criar")
    public String criar (FoodDTO foodDTO, Model model){
        FoodDTO criarComida = foodItemService.salvar(foodDTO);
        model.addAttribute("criarComida", criarComida);
        return "criarComida";
    }

    @GetMapping("/listar")
    public String listar(Model model) {
        List<FoodDTO> listaDeAimentos = foodItemService.listar();
        model.addAttribute("listaDeAimentos", listaDeAimentos);
        return "listaDeAimentos";
    }

    @GetMapping("/listarId")
    public String listarPorId (@PathVariable Long id, Model model){
        FoodDTO informacoesDaComida = foodItemService.listarPorId(id);
        model.addAttribute("informacoesDaComida", informacoesDaComida);
        return "informacoesDaComida";
    }

    @GetMapping("/deletar")
    public String deletar(@PathVariable Long id, Model model){
        FoodDTO deletar = foodItemService.listarPorId(id);
        return "redirect:/food/ui/home";
    }

    @GetMapping("/atualizar")
    public String atualizar (@PathVariable Long id, FoodDTO atualizacao, Model model){
        FoodDTO modificar = foodItemService.atualizar(id, atualizacao);
        model.addAttribute("modificar", modificar);
        return "modificar";
    }


    ///////////////////////////////////////////////////////////////////////////////


    @PostMapping("/criar")
    public ResponseEntity<FoodDTO> criar(@RequestBody FoodDTO foodDTO) {
        FoodDTO save = foodItemService.salvar(foodDTO);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FoodDTO>> listar(){
        List<FoodDTO> listarComidas = foodItemService.listar();
        return ResponseEntity.ok(listarComidas);
    }

    @GetMapping("/listarId/{id}")
    public ResponseEntity<FoodDTO> listarPorId(@PathVariable Long id) {
        FoodDTO foodDTO = foodItemService.listarPorId(id);
        if (foodDTO == null) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foodDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarItem (@PathVariable Long id){
        foodItemService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<FoodDTO> atualizarItem(@PathVariable Long id, @RequestBody FoodDTO atualizacao){
        FoodDTO atualizado = foodItemService.atualizar(id, atualizacao);
        return ResponseEntity.ok(atualizado);
    }






}
