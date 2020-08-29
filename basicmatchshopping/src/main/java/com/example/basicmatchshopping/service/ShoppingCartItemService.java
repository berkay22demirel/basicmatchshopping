package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.ShoppingCartItemDTO;

public interface ShoppingCartItemService {

	public int create(ShoppingCartItemDTO shoppingCartItemDTO);

	public void update(ShoppingCartItemDTO shoppingCartItemDTO);

	public void delete(int id);

	public List<ShoppingCartItemDTO> getAll();

}
