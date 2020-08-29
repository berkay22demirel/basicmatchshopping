package com.example.basicmatchshopping.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderDate;

}
