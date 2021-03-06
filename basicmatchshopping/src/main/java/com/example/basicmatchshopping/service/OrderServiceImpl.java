package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.OrderDTO;
import com.example.basicmatchshopping.entity.Order;
import com.example.basicmatchshopping.repository.OrderRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ShoppingCartService shoppingCartService;

	@Override
	public OrderDTO buy(OrderDTO orderDTO) {
		Order order = MapperUtil.convertToOrder(orderDTO);
		shoppingCartService.setPassiveToShoppingCart(orderDTO.getShoppingCartDTO().getId());
		orderDTO = MapperUtil.convertToOrderDTO(orderRepository.save(order));
		return orderDTO;
	}

	@Override
	public List<OrderDTO> getOrdersByUserId(int userId) {
		return MapperUtil.convertToOrderDTOs(orderRepository.findOrdersByUserId(userId));
	}

}
