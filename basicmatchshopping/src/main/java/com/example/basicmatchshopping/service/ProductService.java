package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.ProductDTO;
import com.example.basicmatchshopping.entity.Product;

import javassist.NotFoundException;

public interface ProductService {

	public int create(Product product);

	public void update(Product product);

	public void delete(int id);

	public Product findByName(String name) throws NotFoundException;

	public List<ProductDTO> findProductsByCategoryId(int categoryId);

	public List<Product> findAll();
}
