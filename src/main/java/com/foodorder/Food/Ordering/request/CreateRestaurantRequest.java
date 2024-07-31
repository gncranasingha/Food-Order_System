package com.foodorder.Food.Ordering.request;

import com.foodorder.Food.Ordering.model.Address;
import com.foodorder.Food.Ordering.model.ContactInfomation;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {

    private Long id;
    private String name;
    private String description;
    private String cuisineType;
    private Address address;
    private ContactInfomation contactInfomation;
    private String openingHours;
    private List<String> images;


}
