package com.example.basicmatchshopping.dto;

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
public class ProductDTO {

	private int id;
	@NotEmpty
	@Size(min = 6, max = 50)
	private int name;
	private CategoryDTO categoryDTO;
	@Size(max = 100)
	private String imagePath;

}
