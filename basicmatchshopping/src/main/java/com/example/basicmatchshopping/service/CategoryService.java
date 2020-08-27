package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.CategoryDTO;

public interface CategoryService {

	public CategoryDTO create(CategoryDTO categoryDTO);

	public CategoryDTO update(CategoryDTO categoryDTO);

	public void delete(int id);

	public List<CategoryDTO> getAll();

}
