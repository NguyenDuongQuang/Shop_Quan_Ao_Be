package com.example.backend.service.view;

import com.example.backend.dto.sale.*;
import com.example.backend.entity.CartGeneral;

public interface CartService {

    CartDto getCart(String userAuthToken);

    AddItemToCartDto addItemToCart(ItemAddedToCartDto itemAddedToCartDto);

    CartGeneral updateItemQuantityToCart(ItemQuantityUpdateToCartDto itemQuantityUpdateToCartDto);

    CartGeneral removeItemFromCart(ItemRemovedFromCartDto itemRemovedFromCartDto);

    void removeAllFromCart(String removeCartUser);

}
