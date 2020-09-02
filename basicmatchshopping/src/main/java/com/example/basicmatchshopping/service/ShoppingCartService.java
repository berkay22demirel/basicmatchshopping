package com.example.basicmatchshopping.service;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;

public interface ShoppingCartService {

	public ShoppingCartDTO getActiveShoppingCartByUserId(int userId);

	public void update(ShoppingCartDTO shoppingCartDTO);
}
