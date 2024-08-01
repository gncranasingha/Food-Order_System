package com.foodorder.Food.Ordering.controller;

import com.foodorder.Food.Ordering.Service.FoodService;
import com.foodorder.Food.Ordering.Service.RestaurantService;
import com.foodorder.Food.Ordering.Service.UserService;
import com.foodorder.Food.Ordering.model.Food;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> createFood(@RequestParam String name,
                                                 @RequestBody CreateFoodRequest req,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.searchFood(name);
        return new ResponseEntity<>(foods, HttpStatus.CREATED);

    }

 @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Food>> getRestaurantsFood(@RequestParam boolean vegeterian,
                                                 @RequestBody boolean seasonal,
                                                 @RequestBody boolean nonveg,
                                                 @RequestParam(required = false) String food_category,
                                                 @RequestBody Long restaurantId,
                                                 @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        List<Food> foods = foodService.getRestaurantFood(restaurantId,vegeterian,nonveg,seasonal,food_category);
        return new ResponseEntity<>(foods, HttpStatus.OK);

    }

}
