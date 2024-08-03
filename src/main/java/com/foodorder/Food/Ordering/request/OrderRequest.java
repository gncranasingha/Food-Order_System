package com.foodorder.Food.Ordering.request;

import com.foodorder.Food.Ordering.model.Address;
import lombok.Data;

@Data
public class OrderRequest {

    private Long restaurantId;
    private Address deliveryAddress;

}
