package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.dto.SubProductDTO;
import com.example.basicmatchshopping.entity.SubProduct;
import com.example.basicmatchshopping.repository.SubProductRepository;
import com.example.basicmatchshopping.util.MapperUtil;

import javassist.NotFoundException;

@Service
public class SubProductServiceImpl implements SubProductService {

	@Autowired
	private SubProductRepository subProductRepository;

	@Override
	public int create(SubProductDTO subProductDTO) {
		SubProduct subProduct = MapperUtil.convertToSubProduct(subProductDTO);
		return subProductRepository.save(subProduct).getId();
	}

	@Override
	public int create(SubProduct subProduct) {
		return subProductRepository.save(subProduct).getId();
	}

	@Override
	public void update(SubProductDTO subProductDTO) {
		SubProduct subProduct = MapperUtil.convertToSubProduct(subProductDTO);
		subProductRepository.save(subProduct);
	}

	@Override
	public void update(SubProduct subProduct) {
		subProductRepository.save(subProduct);
	}

	@Override
	public void delete(int id) {
		subProductRepository.deleteById(id);
	}

	@Override
	public List<SubProductDTO> getAll() {
		return MapperUtil.convertToSubProductDTOs(subProductRepository.findAll());
	}

	@Override
	public SubProduct findByProductId(int productId) throws NotFoundException {
		List<SubProduct> subProducts = subProductRepository.findByProductId(productId);
		if (CollectionUtils.isEmpty(subProducts)) {
			throw new NotFoundException("" + productId);
		}
		return subProducts.get(0);
	}

	@Override
	public void deleteAllBySource(String source) {
		subProductRepository.deleteAllBySource(source);
	}

}
