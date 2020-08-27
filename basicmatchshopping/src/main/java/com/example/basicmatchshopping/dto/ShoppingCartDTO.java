package com.example.basicmatchshopping.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

	private int id;
	private UserDTO userDTO;
	private List<ShoppingCartItemDTO> shoppingCartItemDTOs;
	private double totalAmount;

}
