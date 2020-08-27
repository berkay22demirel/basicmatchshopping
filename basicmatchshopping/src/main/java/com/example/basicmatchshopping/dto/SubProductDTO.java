package com.example.basicmatchshopping.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
	@Min(value = 1)
	private int source;
	@Min(value = 0)
	private double price;
	@Min(value = 1)
	private int amountType;
	@Min(value = 0)
	private double amount;
	@NotEmpty
	@Size(min = 6, max = 400)
	private String sourceLink;
}
