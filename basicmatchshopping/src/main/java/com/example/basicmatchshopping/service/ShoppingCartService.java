package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;

public interface ShoppingCartService {

	public int create(ShoppingCartDTO shoppingCartDTO);

	public void update(ShoppingCartDTO shoppingCartDTO);

	public void delete(int id);

	public List<ShoppingCartDTO> getAll();

}
