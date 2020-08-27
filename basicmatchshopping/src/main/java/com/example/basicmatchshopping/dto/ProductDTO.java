package com.example.basicmatchshopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private int id;
	private int name;
	private CategoryDTO categoryDTO;
	private String imagePath;

}
