package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.SubProductDTO;
import com.example.basicmatchshopping.entity.SubProduct;

import javassist.NotFoundException;

public interface SubProductService {

	public int create(SubProductDTO subProductDTO);

	public int create(SubProduct subProduct);

	public void update(SubProductDTO subProductDTO);

	public void update(SubProduct subProduct);

	public void delete(int id);

	public List<SubProductDTO> getAll();

	public SubProduct findByProductId(int productId) throws NotFoundException;

	public void deleteAllBySource(String source);

}
