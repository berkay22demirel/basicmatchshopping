package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;

public interface ShoppingCartService {

	public ShoppingCartDTO create(ShoppingCartDTO shoppingCartDTO);

	public ShoppingCartDTO update(ShoppingCartDTO shoppingCartDTO);

	public void delete(int id);

	public List<ShoppingCartDTO> getAll();

}
