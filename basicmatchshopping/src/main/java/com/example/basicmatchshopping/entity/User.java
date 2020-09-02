package com.example.basicmatchshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private int id;

	@NotEmpty
	@Size(min = 6, max = 15)
	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@NotEmpty
	@Size(min = 6, max = 15)
	@Column(name = "password", nullable = false)
	private String password;

	@NotEmpty
	@Size(min = 3, max = 20)
	@Column(name = "name", nullable = false)
	private String name;

	@NotEmpty
	@Size(min = 3, max = 20)
	@Column(name = "surname", nullable = false)
	private String surname;

	@NotEmpty
	@Size(min = 6, max = 50)
	@Column(name = "email", nullable = false)
	private String email;

}
