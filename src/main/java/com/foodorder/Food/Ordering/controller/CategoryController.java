package com.foodorder.Food.Ordering.controller;

import com.foodorder.Food.Ordering.Service.UserService;
import com.foodorder.Food.Ordering.Service.categoryService;
import com.foodorder.Food.Ordering.model.Category;
import com.foodorder.Food.Ordering.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private categoryService CategoryService;

    @Autowired
    private UserService userService;

    @PostMapping("/admin/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category,
                                                   @RequestHeader("Authorization") String jwt ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Category CreateCategory = CategoryService.createCategory(category.getName(), user.getId());

        return new ResponseEntity<>(CreateCategory, HttpStatus.CREATED);
    }

 @GetMapping("/category/restaurant")
    public ResponseEntity<List<Category>> getRestaurantCategory(
                                                   @RequestHeader("Authorization") String jwt ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Category> Categories = CategoryService.findCategoryByRestaurantId(user.getId());

        return new ResponseEntity<>(Categories, HttpStatus.CREATED);
    }


}
