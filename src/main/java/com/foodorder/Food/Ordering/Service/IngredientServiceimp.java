package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.IngredientCategory;
import com.foodorder.Food.Ordering.model.IngredientsItem;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.repository.IngredientCategoryRepository;
import com.foodorder.Food.Ordering.repository.IngredientItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientServiceimp implements IngredientService{

    @Autowired
    private IngredientItemRepository ingredientItemRepository;

    @Autowired
    private IngredientCategoryRepository ingredientCategoryRepository;

    @Autowired
    private RestaurantService restaurantService;


    @Override
    public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {

        Restaurent restaurent = restaurantService.findRestaurantById(restaurantId);
        IngredientCategory category = new IngredientCategory();
        category.setRestaurent(restaurent);
        category.setName(name);

        return ingredientCategoryRepository.save(category);
    }

    @Override
    public IngredientCategory findIngredientCategoryById(Long id) throws Exception {

        Optional<IngredientCategory> opt = ingredientCategoryRepository.findById(id);
        if (opt.isEmpty()){
            throw new Exception("ingredient category not found");
        }

        return opt.get();
    }

    @Override
    public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {

        restaurantService.findRestaurantById(id);

        return ingredientCategoryRepository.findByRestaurentId(id);
    }

    @Override
    public IngredientsItem createIngredientItem(Long restaurantId, String IngredientName, Long categoryId) throws Exception {

        Restaurent restaurent = restaurantService.findRestaurantById(restaurantId);
        IngredientCategory category = findIngredientCategoryById(categoryId);
        IngredientsItem item = new IngredientsItem();
        item.setName(IngredientName);
        item.setRestaurent(restaurent);
        item.setCategory(category);
        IngredientsItem ingredient = ingredientItemRepository.save(item);
        category.getIngredients().add(ingredient);

        return ingredient;
    }

    @Override
    public List<IngredientsItem> findRestaurantsIngredients(Long restaurantId) throws Exception {

        // Ensure that the restaurant exists if necessary
        restaurantService.findRestaurantById(restaurantId);

        return ingredientItemRepository.findByRestaurent_Id(restaurantId);
    }

    @Override
    public IngredientsItem updateStack(Long id) throws Exception {

        Optional<IngredientsItem> optionalIngredientsItem = ingredientItemRepository.findById(id);
        if (optionalIngredientsItem.isEmpty()){
            throw new Exception("ingredient not found");
        }
        IngredientsItem ingredientsItem = optionalIngredientsItem.get();
        ingredientsItem.setInStoke(!ingredientsItem.isInStoke());

        return ingredientItemRepository.save(ingredientsItem);
    }
}
