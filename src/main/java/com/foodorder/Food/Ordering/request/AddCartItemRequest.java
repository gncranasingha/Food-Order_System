package com.foodorder.Food.Ordering.request;

import lombok.Data;

import java.util.List;

@Data
public class AddCartItemRequest {

    private Long foodId;
    private int Quantity;
    private List<String> ingredients;

}
