package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;
import com.example.basicmatchshopping.entity.ShoppingCart;
import com.example.basicmatchshopping.entity.User;
import com.example.basicmatchshopping.repository.ShoppingCartRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public ShoppingCartDTO getActiveShoppingCartByUserId(int userId) {
		List<ShoppingCart> activeShoppingCarts = shoppingCartRepository.findActiveShoppingCartByUserId(userId);
		if (CollectionUtils.isEmpty(activeShoppingCarts)) {
			ShoppingCart shoppingCart = new ShoppingCart();
			User user = new User();
			user.setId(userId);
			shoppingCart.setUser(user);
			shoppingCart.setActive(true);
			shoppingCart.setTotalAmount(0.0);
			return MapperUtil.convertToShoppingCartDTO(shoppingCartRepository.save(shoppingCart));
		} else {
			return MapperUtil.convertToShoppingCartDTO(activeShoppingCarts.get(0));
		}
	}

	@Override
	public void update(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = MapperUtil.convertToShoppingCart(shoppingCartDTO);
		shoppingCartRepository.save(shoppingCart);
	}

}
