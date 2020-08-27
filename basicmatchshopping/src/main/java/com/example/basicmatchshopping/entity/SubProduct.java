package com.example.basicmatchshopping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sub_product")
public class SubProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
	private Product product;

	@Column(name = "source", nullable = false)
	private int source;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "amount_type", nullable = false)
	private int amountType;

	@Column(name = "amount", nullable = false)
	private double amount;

	@Column(name = "source_link", nullable = false)
	private String sourceLink;
}
