package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.Category;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceimp implements categoryService{

    private RestaurantService restaurantService;
    private CategoryRepository categoryRepository;


    @Override
    public Category createCategory(String name, Long userId) throws Exception {

        Restaurent restaurent = restaurantService.getRestaurantByUserId(userId);
        Category category = new Category();
        category.setName(name);
        category.setRestaurent(restaurent);
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception {
        Restaurent restaurent = restaurantService.getRestaurantByUserId(id);
        return categoryRepository.findByRestaurentId(restaurent.getId());
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()){
            throw new Exception("Category not found");
        }

        return optionalCategory.get();
    }
}
