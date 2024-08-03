package com.foodorder.Food.Ordering.controller;

import com.foodorder.Food.Ordering.Service.OrderService;
import com.foodorder.Food.Ordering.Service.UserService;
import com.foodorder.Food.Ordering.model.CartItem;
import com.foodorder.Food.Ordering.model.Order;
import com.foodorder.Food.Ordering.model.User;
import com.foodorder.Food.Ordering.request.AddCartItemRequest;
import com.foodorder.Food.Ordering.request.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                  @RequestHeader("Authorization") String jwt ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req,user);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderistory(
                                                  @RequestHeader("Authorization") String jwt ) throws Exception {
        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getUserOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
