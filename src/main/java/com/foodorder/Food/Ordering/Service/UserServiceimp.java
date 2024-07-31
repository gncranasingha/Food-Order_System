package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.config.JwtProvider;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimp implements UserService{

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
       String email =  jwtProvider.getEmailFromJwtToken(jwt);
       User user = findUserByEmail(email);
       return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if (user == null){
            throw new Exception("user not Found");
        }
        return null;
    }
}
