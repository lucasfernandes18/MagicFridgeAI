package dev.java10x.MagicFridgeIa.repository;

import dev.java10x.MagicFridgeIa.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}
