package com.example.basicmatchshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubProductDTO {

	private int id;
	private ProductDTO productDTO;
	private int source;
	private double price;
	private int amountType;
	private double amount;
	private String sourceLink;
}
