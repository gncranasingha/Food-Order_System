package com.foodorder.Food.Ordering.controller;

import com.foodorder.Food.Ordering.Service.FoodService;
import com.foodorder.Food.Ordering.Service.RestaurantService;
import com.foodorder.Food.Ordering.Service.UserService;
import com.foodorder.Food.Ordering.model.Food;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.request.CreateFoodRequest;
import com.foodorder.Food.Ordering.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {

    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Restaurent restaurent = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req, req.getCategory(),restaurent);
        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }
 @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

     MessageResponse res = new MessageResponse();
     res.setMessage("Food deleted Successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }
@PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable Long id, @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvailabilityStatus(id);





        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }

}
