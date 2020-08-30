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
public class CategoryDTO {

	private int id;
	@NotEmpty
	@Size(min = 6, max = 50)
	private String name;
	@Size(max = 500)
	private String imagePath;

}
