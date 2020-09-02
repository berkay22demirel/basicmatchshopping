package com.example.basicmatchshopping.service;

import com.example.basicmatchshopping.dto.ShoppingCartItemDTO;

public interface ShoppingCartItemService {

	public int add(ShoppingCartItemDTO shoppingCartItemDTO);

	public void update(ShoppingCartItemDTO shoppingCartItemDTO);

	public void delete(int id);

}
