package com.example.basicmatchshopping.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

	private int id;
	private UserDTO userDTO;
	private ShoppingCartDTO shoppingCartDTO;
	@NotEmpty
	private Date orderDate;

}
