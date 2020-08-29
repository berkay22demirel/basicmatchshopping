package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.CategoryDTO;
import com.example.basicmatchshopping.entity.Category;
import com.example.basicmatchshopping.repository.CategoryRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public int create(CategoryDTO categoryDTO) {
		Category category = MapperUtil.convertToCategory(categoryDTO);
		return categoryRepository.save(category).getId();
	}

	@Override
	public void update(CategoryDTO categoryDTO) {
		Category category = MapperUtil.convertToCategory(categoryDTO);
		categoryRepository.save(category);
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<CategoryDTO> getAll() {
		return MapperUtil.convertToCategoryDTOs(categoryRepository.findAll());
	}

}
