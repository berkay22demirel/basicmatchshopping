package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.CategoryDTO;
import com.example.basicmatchshopping.entity.Category;

import javassist.NotFoundException;

public interface CategoryService {

	public int create(CategoryDTO categoryDTO);

	public void update(CategoryDTO categoryDTO);

	public void delete(int id);

	public List<CategoryDTO> getAll();

	public Category findByName(String name) throws NotFoundException;

}
