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

	@Override
	public int create(OrderDTO orderDTO) {
		Order order = MapperUtil.convertToOrder(orderDTO);
		return orderRepository.save(order).getId();
	}

	@Override
	public void update(OrderDTO orderDTO) {
		Order order = MapperUtil.convertToOrder(orderDTO);
		orderRepository.save(order);
	}

	@Override
	public void delete(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public List<OrderDTO> getAll() {
		return MapperUtil.convertToOrderDTOs(orderRepository.findAll());
	}

	@Override
	public List<OrderDTO> getOrdersByUserId(int userId) {
		return MapperUtil.convertToOrderDTOs(orderRepository.findOrdersByUserId(userId));
	}

}
