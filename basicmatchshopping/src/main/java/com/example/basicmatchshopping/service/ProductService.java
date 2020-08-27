package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.ProductDTO;

public interface ProductService {

	public ProductDTO create(ProductDTO productDTO);

	public ProductDTO update(ProductDTO productDTO);

	public void delete(int id);

	public List<ProductDTO> getAll();
}
