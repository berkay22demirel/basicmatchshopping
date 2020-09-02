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
public class UserDTO {

	private int id;

	@NotEmpty
	@Size(min = 6, max = 15)
	private String username;

	@NotEmpty
	@Size(min = 6, max = 15)
	private String password;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String name;

	@NotEmpty
	@Size(min = 3, max = 20)
	private String surname;

	@NotEmpty
	@Size(min = 6, max = 50)
	private String email;

}
