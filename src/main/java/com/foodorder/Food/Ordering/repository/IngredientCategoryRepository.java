package com.foodorder.Food.Ordering.repository;

import com.foodorder.Food.Ordering.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Long> {

    List<IngredientCategory> findByRestaurentId(Long id);

}
