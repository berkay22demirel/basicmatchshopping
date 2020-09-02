package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.OrderDTO;

public interface OrderService {

	public int buy(OrderDTO orderDTO);

	public List<OrderDTO> getOrdersByUserId(int userId);

}
