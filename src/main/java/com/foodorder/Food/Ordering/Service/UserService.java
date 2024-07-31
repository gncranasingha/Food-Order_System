package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;
    public User findUserByEmail(String email ) throws Exception;
}
