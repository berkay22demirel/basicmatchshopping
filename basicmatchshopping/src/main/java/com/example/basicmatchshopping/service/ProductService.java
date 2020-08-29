package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.ProductDTO;

public interface ProductService {

	public int create(ProductDTO productDTO);

	public void update(ProductDTO productDTO);

	public void delete(int id);

	public List<ProductDTO> getAll();
}
