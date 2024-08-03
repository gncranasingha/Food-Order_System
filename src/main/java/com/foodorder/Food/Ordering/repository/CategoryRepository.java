package com.foodorder.Food.Ordering.repository;

import com.foodorder.Food.Ordering.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

    public List<Category> findByRestaurentId(Long id);
}
