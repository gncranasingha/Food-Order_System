package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.Category;
import com.foodorder.Food.Ordering.model.Food;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {

    public Food createFood(CreateFoodRequest req, Category category, Restaurent restaurent);

    void deleteFood(Long foodId) throws Exception;

    public List<Food> getRestaurantFood(Long restaurantId, boolean isvegeterian, boolean isNonveg, boolean isSeasonal, String foodCategory);

    public List<Food> searchFood (String keyword);

    public Food findFoodById(Long foodId) throws Exception;

    public Food updateAvailabilityStatus(Long foodId) throws Exception;

}
