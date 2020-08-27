package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.OrderDTO;

public interface OrderService {

	public OrderDTO create(OrderDTO orderDTO);

	public OrderDTO update(OrderDTO orderDTO);

	public void delete(int id);

	public List<OrderDTO> getAll();

}
