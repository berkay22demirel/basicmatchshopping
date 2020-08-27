package com.example.basicmatchshopping.dto;

import javax.validation.constraints.Min;

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
	@Min(value = 1)
	private int quantity;

}
