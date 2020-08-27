package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.OrderDTO;
import com.example.basicmatchshopping.entity.Order;
import com.example.basicmatchshopping.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public OrderDTO create(OrderDTO orderDTO) {
		Order order = convertToEntity(orderDTO);
		return convertToDTO(orderRepository.save(order));
	}

	@Override
	public OrderDTO update(OrderDTO orderDTO) {
		Order order = convertToEntity(orderDTO);
		return convertToDTO(orderRepository.save(order));
	}

	@Override
	public void delete(int id) {
		orderRepository.deleteById(id);
	}

	@Override
	public List<OrderDTO> getAll() {
		return convertToDTOs(orderRepository.findAll());
	}

	private Order convertToEntity(OrderDTO orderDTO) {
		return modelMapper.map(orderDTO, Order.class);
	}

	private OrderDTO convertToDTO(Order order) {
		return modelMapper.map(order, OrderDTO.class);
	}

	private List<OrderDTO> convertToDTOs(Iterable<Order> orders) {
		List<OrderDTO> orderDTOs = new ArrayList<>();
		for (Order order : orders) {
			orderDTOs.add(convertToDTO(order));
		}
		return orderDTOs;
	}

}
