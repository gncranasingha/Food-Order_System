package com.foodorder.Food.Ordering.repository;

import com.foodorder.Food.Ordering.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
