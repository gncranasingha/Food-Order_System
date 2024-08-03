package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.Category;

import java.util.List;

public interface categoryService {

    public Category createCategory(String name, Long userId) throws Exception;
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception;

    public Category findCategoryById(Long id) throws Exception;

}
