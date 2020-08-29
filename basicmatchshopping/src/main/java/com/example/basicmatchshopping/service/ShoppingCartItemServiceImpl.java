package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.ShoppingCartItemDTO;
import com.example.basicmatchshopping.entity.ShoppingCartItem;
import com.example.basicmatchshopping.repository.ShoppingCartItemRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {

	@Autowired
	private ShoppingCartItemRepository shoppingCartItemRepository;

	@Override
	public int create(ShoppingCartItemDTO shoppingCartItemDTO) {
		ShoppingCartItem shoppingCartItem = MapperUtil.convertToShoppingCartItem(shoppingCartItemDTO);
		return shoppingCartItemRepository.save(shoppingCartItem).getId();
	}

	@Override
	public void update(ShoppingCartItemDTO shoppingCartItemDTO) {
		ShoppingCartItem shoppingCartItem = MapperUtil.convertToShoppingCartItem(shoppingCartItemDTO);
		shoppingCartItemRepository.save(shoppingCartItem);
	}

	@Override
	public void delete(int id) {
		shoppingCartItemRepository.deleteById(id);
	}

	@Override
	public List<ShoppingCartItemDTO> getAll() {
		return MapperUtil.convertToShoppingCartItemDTOs(shoppingCartItemRepository.findAll());
	}

}
