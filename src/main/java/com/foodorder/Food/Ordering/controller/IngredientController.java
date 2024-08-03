package com.foodorder.Food.Ordering.controller;

import com.foodorder.Food.Ordering.Service.IngredientService;
import com.foodorder.Food.Ordering.model.IngredientCategory;
import com.foodorder.Food.Ordering.model.IngredientsItem;
import com.foodorder.Food.Ordering.request.IngredientCategoryRequest;
import com.foodorder.Food.Ordering.request.IngredientRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

    private IngredientService ingredientService;

    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientCategory(
        @RequestBody IngredientCategoryRequest req) throws Exception {

        IngredientCategory item = ingredientService.createIngredientCategory(req.getName(), req.getRestaurantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<IngredientsItem> createIngredientItem(
        @RequestBody IngredientRequest req) throws Exception {

        IngredientsItem item = ingredientService.createIngredientItem(req.getRestaurantId(), req.getName(), req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }
     @PutMapping("/{id}/stack")
    public ResponseEntity<IngredientsItem> updateIngredientStack(
        @PathVariable Long id
     ) throws Exception {

        IngredientsItem item = ingredientService.updateStack(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

     @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>> getRestaurantIngredient(
        @PathVariable Long id
     ) throws Exception {

        List<IngredientsItem> items = ingredientService.findRestaurantsIngredients(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

     @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestaurantIngredientCategory(
        @PathVariable Long id
     ) throws Exception {

        List<IngredientCategory> items = ingredientService.findIngredientCategoryByRestaurantId(id);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }


}
