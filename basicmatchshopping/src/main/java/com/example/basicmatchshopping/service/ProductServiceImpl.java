package com.example.basicmatchshopping.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.dto.ProductDTO;
import com.example.basicmatchshopping.entity.Product;
import com.example.basicmatchshopping.repository.ProductRepository;
import com.example.basicmatchshopping.util.MapperUtil;

import javassist.NotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public int create(ProductDTO productDTO) {
		Product product = MapperUtil.convertToProduct(productDTO);
		return productRepository.save(product).getId();
	}

	@Override
	public int create(Product product) {
		return productRepository.save(product).getId();
	}

	@Override
	public void update(ProductDTO productDTO) {
		Product product = MapperUtil.convertToProduct(productDTO);
		productRepository.save(product);
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<ProductDTO> getAll() {
		return MapperUtil.convertToProductDTOs(productRepository.findAll());
	}

	@Override
	public Product findByName(String name) throws NotFoundException {
		Collection<Product> products = productRepository.findByName(name);
		if (CollectionUtils.isEmpty(products)) {
			throw new NotFoundException(name);
		}
		return products.iterator().next();
	}

	@Override
	public List<ProductDTO> findProductsByCategoryId(int categoryId) {
		return MapperUtil.convertToProductDTOs(productRepository.findProductsByCategoryId(categoryId));
	}

}
