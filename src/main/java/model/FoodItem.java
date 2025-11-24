package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_item")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class FoodItem {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Enum<categoria> categoria;
    private Integer quantidade;
    private LocalDate validade;
}
