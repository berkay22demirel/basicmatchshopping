package com.example.basicmatchshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(name = "name", nullable = false, updatable = false, unique = true)
	private int name;

	@Column(name = "category_id", nullable = false, updatable = false)
	private int category_id;

	@Column(name = "image_path", nullable = false, updatable = false)
	private String image_path;

}
