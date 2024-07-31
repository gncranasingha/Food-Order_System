package com.foodorder.Food.Ordering.controller;


import com.foodorder.Food.Ordering.Service.RestaurantService;
import com.foodorder.Food.Ordering.Service.UserService;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.request.CreateRestaurantRequest;
import com.foodorder.Food.Ordering.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestautantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Restaurent> createRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt
            ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Restaurent restaurent = restaurantService.createRestaurant(req,user);
        return new ResponseEntity<>(restaurent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurent> updateRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Restaurent restaurent = restaurantService.updateRestaurant(id,req);
        return new ResponseEntity<>(restaurent, HttpStatus.CREATED);
    }

 @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        restaurantService.updateRestaurant(id,req);
     MessageResponse res = new MessageResponse();
     res.setMessage("restaurant deleted successfully..");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

 @PutMapping("/{id}/status")
    public ResponseEntity<Restaurent> updateRestaurantStatus(

            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

       Restaurent restaurent =  restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurent, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<Restaurent> findRestaurantByUserId(

            @RequestHeader("Authorization") String jwt

    ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);

        Restaurent restaurent =  restaurantService.getRestaurantByUserId(user.getId());

        return new ResponseEntity<>(restaurent, HttpStatus.OK);
    }


}
