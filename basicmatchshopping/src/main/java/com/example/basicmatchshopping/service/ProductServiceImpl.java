package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.ProductDTO;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDTO create(ProductDTO productDTO) {
		Product product = convertToEntity(productDTO);
		return convertToDTO(productRepository.save(product));
	}

	@Override
	public ProductDTO update(ProductDTO productDTO) {
		Product product = convertToEntity(productDTO);
		return convertToDTO(productRepository.save(product));
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ProductDTO> getAll() {
		return convertToDTOs(productRepository.findAll());
	}

	private Product convertToEntity(ProductDTO productDTO) {
		return modelMapper.map(productDTO, Product.class);
	}

	private ProductDTO convertToDTO(Product product) {
		return modelMapper.map(product, ProductDTO.class);
	}

	private List<ProductDTO> convertToDTOs(Iterable<Product> products) {
		List<ProductDTO> productDTOs = new ArrayList<>();
		for (Product product : products) {
			productDTOs.add(convertToDTO(product));
		}
		return productDTOs;
	}

}
