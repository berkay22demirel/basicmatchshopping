package com.example.basicmatchshopping.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.dto.CategoryDTO;
import com.example.basicmatchshopping.entity.Category;
import com.example.basicmatchshopping.repository.CategoryRepository;
import com.example.basicmatchshopping.util.MapperUtil;

import javassist.NotFoundException;

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

	@Override
	public Category findByName(String name) throws NotFoundException {
		Collection<Category> categories = categoryRepository.findByName(name);
		if (CollectionUtils.isEmpty(categories)) {
			throw new NotFoundException(name);
		}
		return categories.iterator().next();
	}

}
