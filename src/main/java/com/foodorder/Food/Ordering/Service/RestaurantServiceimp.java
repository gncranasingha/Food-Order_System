package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.Dto.RestautontDto;
import com.foodorder.Food.Ordering.model.Address;
import com.foodorder.Food.Ordering.model.Restaurent;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.repository.AddressRepository;
import com.foodorder.Food.Ordering.repository.RestaurantRepository;
import com.foodorder.Food.Ordering.repository.UserRepository;
import com.foodorder.Food.Ordering.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceimp implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurent createRestaurant(CreateRestaurantRequest req, User user) {

        Address address = addressRepository.save(req.getAddress());

        Restaurent restaurent =new Restaurent();
        restaurent.setAddress(address);
        restaurent.setContactInfomation(req.getContactInfomation());
        restaurent.setCuisineType(req.getCuisineType());
        restaurent.setDescription(req.getDescription());
        restaurent.setImages(req.getImages());
        restaurent.setOpeningHours(req.getOpeningHours());
        restaurent.setRegistrationDate(LocalDateTime.now());
        restaurent.setOwner(user);

        return restaurantRepository.save(restaurent);
    }

    @Override
    public Restaurent updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception {

        Restaurent restaurent = findRestaurantById(restaurantId);

        if(restaurent.getCuisineType() != null){
            restaurent.setCuisineType(updateRestaurant.getCuisineType());
        }
        if(restaurent.getDescription() != null){
            restaurent.setDescription(updateRestaurant.getDescription());
        }
        if(restaurent.getName() != null){
            restaurent.setName(updateRestaurant.getName());
        }

        return restaurantRepository.save(restaurent);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

        Restaurent restaurent = findRestaurantById(restaurantId);
        restaurantRepository.delete(restaurent);

    }

    @Override
    public List<Restaurent> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurent> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurent findRestaurantById(Long id) throws Exception {

        Optional<Restaurent> opt = restaurantRepository.findById(id);

        if(opt.isEmpty()) {
            throw new Exception("restaurant Not found with id"+id);
        }

        return opt.get();
    }

    @Override
    public Restaurent getRestaurantByUserId(Long userId) throws Exception {

        Restaurent restaurent = restaurantRepository.findByOwnerId(userId);
        if (restaurent == null){
            throw new Exception("Restaurant not found with owner id"+userId);
        }

        return restaurent;
    }

    @Override
    public RestautontDto addToFavorites(Long restaurantId, User user) throws Exception {

        Restaurent restaurent = findRestaurantById(restaurantId);

        RestautontDto dto = new RestautontDto();
        dto.setDescription(restaurent.getDescription());
        dto.setImages(restaurent.getImages());
        dto.setTitle(restaurent.getName());
        dto.setId(restaurantId);

        boolean isFavorited = false;
        List<RestautontDto> favorites = user.getFavorites();
        for (RestautontDto favorite : favorites ){
            if (favorite.getId().equals(restaurantId)){
                isFavorited = true;
                break;
            }
        }

        //if the restaurant is already favorited, remove it: otherwise, add it to favorites
        if (isFavorited){
            favorites.removeIf(favorite -> favorite.getId().equals(restaurantId));
        }
        else {
            favorites.add(dto);
        }



        userRepository.save(user);
        return dto;
    }

    @Override
    public Restaurent updateRestaurantStatus(Long id) throws Exception {

        Restaurent restaurent = findRestaurantById(id);

        return null;
    }
}
