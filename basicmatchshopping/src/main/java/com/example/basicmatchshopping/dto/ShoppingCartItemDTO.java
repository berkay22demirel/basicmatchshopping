package com.example.basicmatchshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItemDTO {

	private int id;
	private ShoppingCartDTO shoppingCartDTO;
	private SubProductDTO subProductDTO;
	private int quantity;

}
