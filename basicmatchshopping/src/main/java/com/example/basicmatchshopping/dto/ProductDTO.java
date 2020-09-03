package com.example.basicmatchshopping.dto;

import java.util.List;

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
	private String name;
	private CategoryDTO categoryDTO;
	private List<SubProductDTO> subProductDTOs;
	@Size(max = 100)
	private String imagePath;

}
