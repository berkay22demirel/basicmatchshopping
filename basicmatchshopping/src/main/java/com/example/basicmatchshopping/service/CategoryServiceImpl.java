package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.CategoryDTO;
import com.example.basicmatchshopping.entity.Category;
import com.example.basicmatchshopping.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDTO create(CategoryDTO categoryDTO) {
		Category category = convertToEntity(categoryDTO);
		return convertToDTO(categoryRepository.save(category));
	}

	@Override
	public CategoryDTO update(CategoryDTO categoryDTO) {
		Category category = convertToEntity(categoryDTO);
		return convertToDTO(categoryRepository.save(category));
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<CategoryDTO> getAll() {
		return convertToDTOs(categoryRepository.findAll());
	}

	private Category convertToEntity(CategoryDTO categoryDTO) {
		return modelMapper.map(categoryDTO, Category.class);
	}

	private CategoryDTO convertToDTO(Category category) {
		return modelMapper.map(category, CategoryDTO.class);
	}

	private List<CategoryDTO> convertToDTOs(Iterable<Category> categories) {
		List<CategoryDTO> categoryDTOs = new ArrayList<>();
		for (Category category : categories) {
			categoryDTOs.add(convertToDTO(category));
		}
		return categoryDTOs;
	}

}
