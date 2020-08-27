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
public class SubProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@Column(name = "product_id", nullable = false, updatable = false)
	private int product_id;

	@Column(name = "source", nullable = false)
	private int source;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "amount_type", nullable = false)
	private int amount_type;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "source_link", nullable = false)
	private String source_link;
}
