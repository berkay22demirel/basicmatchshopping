package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;
import com.example.basicmatchshopping.entity.ShoppingCart;
import com.example.basicmatchshopping.repository.ShoppingCartRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public int create(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = MapperUtil.convertToShoppingCart(shoppingCartDTO);
		return shoppingCartRepository.save(shoppingCart).getId();
	}

	@Override
	public void update(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = MapperUtil.convertToShoppingCart(shoppingCartDTO);
		shoppingCartRepository.save(shoppingCart);
	}

	@Override
	public void delete(int id) {
		shoppingCartRepository.deleteById(id);
	}

	@Override
	public List<ShoppingCartDTO> getAll() {
		return MapperUtil.convertToShoppingCartDTOs(shoppingCartRepository.findAll());
	}

}
