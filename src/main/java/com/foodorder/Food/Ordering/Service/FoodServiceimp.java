package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.Category;
import com.foodorder.Food.Ordering.model.Food;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.repository.FoodRepository;
import com.foodorder.Food.Ordering.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FoodServiceimp  implements FoodService{

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurent restaurent) {

        Food food = new Food();

        food.setFoodCategory(category);
        food.setRestaurent(restaurent);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredientsItems(req.getIngredientsItems());
        food.setSeasonal(req.isSeasional());
        food.setVegetarian(req.isVegeterian());

        Food savedFood = foodRepository.save(food);
        restaurent.getFoods().add(savedFood);


        return savedFood;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {
        Food food = findFoodById(foodId);
        food.setRestaurent(null);
        foodRepository.save(food);
    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId, boolean isvegeterian, boolean isNonveg, boolean isSeasonal, String foodCategory) {

        List<Food> foods = foodRepository.findByRestaurantId(restaurantId);

        if (isvegeterian){
            foods = filterByVegeterian(foods,isvegeterian);
        }
        if (isNonveg){
            foods = filterByNonveg(foods,isNonveg);
        }
        if (isSeasonal){
            foods = filterBySeasonal(foods,isSeasonal);
        }
        if (foodCategory !=null && !foodCategory.equals("")){
            foods = filterByCategory(foods,foodCategory);
        }


        return foods;
    }

    private List<Food> filterByCategory(List<Food> foods, String foodCategory) {

        return foods.stream().filter(food -> {
            if (food.getFoodCategory() != null){
                return food.getFoodCategory().getName().equals(foodCategory);
            }
            return false;
        }).collect(Collectors.toList());

    }

    private List<Food> filterBySeasonal(List<Food> foods, boolean isSeasonal) {

        return foods.stream().filter(food -> food.isSeasonal() == isSeasonal).collect(Collectors.toList());


    }

    private List<Food> filterByNonveg(List<Food> foods, boolean isNonveg) {

        return foods.stream().filter(food -> food.isVegetarian() == false).collect(Collectors.toList());


    }

    private List<Food> filterByVegeterian(List<Food> foods, boolean isvegeterian) {

        return foods.stream().filter(food -> food.isVegetarian() == isvegeterian).collect(Collectors.toList());

    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepository.searchFood(keyword);
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {

        Optional<Food> optionalFood = foodRepository.findById(foodId);

        if (optionalFood.isEmpty()){
            throw new Exception("food not exist...");
        }
        return optionalFood.get();
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {

        Food food = findFoodById(foodId);
        food.setAvailable(food.isAvailable());
        foodRepository.save(food);

        return null;
    }
}
