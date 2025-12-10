package dev.java10x.MagicFridgeIa.service;


import dev.java10x.MagicFridgeIa.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private Long Id;
    private String nome;
    private Categoria categoria;
    private Integer quantidade;
    private LocalDate validade;


}
