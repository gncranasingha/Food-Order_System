package com.foodorder.Food.Ordering.Service;

import com.foodorder.Food.Ordering.model.Cart;
import com.foodorder.Food.Ordering.model.CartItem;
import com.foodorder.Food.Ordering.request.AddCartItemRequest;

public interface CartService {

    public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;
    public CartItem updateCartitemQuantity(Long cartItemId, int Queantity) throws Exception;
    public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;

    public Long calculateCartTotals(Cart cart) throws Exception;

    public Cart findCartById(Long id) throws Exception;
    public Cart findCartByUserId(String jwt) throws Exception;
    public Cart clearCart(String jwt) throws Exception;

}
