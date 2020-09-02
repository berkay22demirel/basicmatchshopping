package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.OrderDTO;

public interface OrderService {

	public int create(OrderDTO orderDTO);

	public void update(OrderDTO orderDTO);

	public void delete(int id);

	public List<OrderDTO> getAll();

	public List<OrderDTO> getOrdersByUserId(int userId);

}
