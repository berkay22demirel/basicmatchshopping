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
public class AuthRequest {

	@NotEmpty
	@Size(min = 6, max = 15)
	private String username;
	@NotEmpty
	@Size(min = 6, max = 15)
	private String password;

}
