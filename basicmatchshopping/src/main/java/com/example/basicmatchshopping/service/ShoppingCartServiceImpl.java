package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;
import com.example.basicmatchshopping.entity.ShoppingCart;
import com.example.basicmatchshopping.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ShoppingCartDTO create(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = convertToEntity(shoppingCartDTO);
		return convertToDTO(shoppingCartRepository.save(shoppingCart));
	}

	@Override
	public ShoppingCartDTO update(ShoppingCartDTO shoppingCartDTO) {
		ShoppingCart shoppingCart = convertToEntity(shoppingCartDTO);
		return convertToDTO(shoppingCartRepository.save(shoppingCart));
	}

	@Override
	public void delete(int id) {
		shoppingCartRepository.deleteById(id);
	}

	@Override
	public List<ShoppingCartDTO> getAll() {
		return convertToDTOs(shoppingCartRepository.findAll());
	}

	private ShoppingCart convertToEntity(ShoppingCartDTO shoppingCartDTO) {
		return modelMapper.map(shoppingCartDTO, ShoppingCart.class);
	}

	private ShoppingCartDTO convertToDTO(ShoppingCart shoppingCart) {
		return modelMapper.map(shoppingCart, ShoppingCartDTO.class);
	}

	private List<ShoppingCartDTO> convertToDTOs(Iterable<ShoppingCart> shoppingCarts) {
		List<ShoppingCartDTO> shoppingCartDTOs = new ArrayList<>();
		for (ShoppingCart shoppingCart : shoppingCarts) {
			shoppingCartDTOs.add(convertToDTO(shoppingCart));
		}
		return shoppingCartDTOs;
	}

}
