package dev.java10x.MagicFridgeIa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "food_item")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class FoodItem {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "Categoria")
    @Enumerated(EnumType.STRING) // sem essa anotação, o hibernate por padrão espera que seja armazenado um número inteiro
    private Categoria categoria;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "validade")
    private LocalDate validade;

    @Column(name = "unidade")
    private String unidade;
}
