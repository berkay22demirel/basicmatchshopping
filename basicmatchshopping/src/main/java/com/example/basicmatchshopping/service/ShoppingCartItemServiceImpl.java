package com.example.basicmatchshopping.service;

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
	@Autowired
	private ShoppingCartService shoppingCartService;

	@Override
	public int add(ShoppingCartItemDTO shoppingCartItemDTO) {
		ShoppingCartItem shoppingCartItem = MapperUtil.convertToShoppingCartItem(shoppingCartItemDTO);
		int id = shoppingCartItemRepository.save(shoppingCartItem).getId();
		shoppingCartService.recalculateTotalAmount(shoppingCartItem.getShoppingCart().getId());
		return id;
	}

	@Override
	public void update(ShoppingCartItemDTO shoppingCartItemDTO) {
		ShoppingCartItem shoppingCartItem = MapperUtil.convertToShoppingCartItem(shoppingCartItemDTO);
		shoppingCartItemRepository.save(shoppingCartItem);
		shoppingCartService.recalculateTotalAmount(shoppingCartItem.getShoppingCart().getId());
	}

	@Override
	public void delete(int id) {
		ShoppingCartItem shoppingCartItem = shoppingCartItemRepository.findById(id).get();
		if (shoppingCartItem != null) {
			shoppingCartItemRepository.deleteById(id);
			shoppingCartService.recalculateTotalAmount(shoppingCartItem.getShoppingCart().getId());
		}
	}

}
