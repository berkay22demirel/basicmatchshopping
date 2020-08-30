package com.example.basicmatchshopping.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.basicmatchshopping.constant.AmountType;
import com.example.basicmatchshopping.constant.Source;

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
	private Source source;
	@Min(value = 0)
	private double price;
	private AmountType amountType;
	@Min(value = 0)
	private double amount;
	@NotEmpty
	@Size(min = 6, max = 1000)
	private String sourceLink;
}
