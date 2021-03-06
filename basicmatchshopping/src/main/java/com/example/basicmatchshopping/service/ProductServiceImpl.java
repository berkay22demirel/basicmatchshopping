package com.example.basicmatchshopping.service;

import java.util.Collection;
import java.util.Iterator;
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
	public int create(Product product) {
		return productRepository.save(product).getId();
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
	public Product findByName(String name) throws NotFoundException {
		Collection<Product> products = productRepository.findByName(name);
		if (CollectionUtils.isEmpty(products)) {
			throw new NotFoundException(name);
		}
		return products.iterator().next();
	}

	@Override
	public List<ProductDTO> findProductsByCategoryId(int categoryId) {
		List<Product> products = productRepository.findProductsByCategoryId(categoryId);
		Iterator<Product> i = products.iterator();
		while (i.hasNext()) {
			Product product = i.next();

			if (product.getSubProducts().size() < 2) {
				i.remove();
			}
		}
		return MapperUtil.convertToProductDTOs(products);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

}
