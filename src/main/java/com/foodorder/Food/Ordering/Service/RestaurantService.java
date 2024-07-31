package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.Dto.RestautontDto;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {

    public Restaurent createRestaurant(CreateRestaurantRequest req, User user);
    public Restaurent updateRestaurant(Long restaurentId, CreateRestaurantRequest updateRestaurant) throws Exception;
    public void deleteRestaurant(Long restaurantId) throws Exception;
    public List<Restaurent> getAllRestaurant();
    public List<Restaurent> searchRestaurant(String keyword);
    public Restaurent findRestaurantById(Long id) throws Exception;
    public Restaurent getRestaurantByUserId(Long userId)throws Exception;

    public RestautontDto addToFavorites(Long restaurantId, User user)throws Exception;
    public Restaurent updateRestaurantStatus(Long id) throws Exception;
}

