package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.CategoryDTO;
import com.example.basicmatchshopping.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody CategoryDTO category) throws Exception {
		CategoryDTO createdCategory = categoryService.create(category);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody CategoryDTO category) throws Exception {
		CategoryDTO updatedCategory = categoryService.update(category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		categoryService.delete(id);
		return new ResponseEntity<>("Category is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getAll")
	public ResponseEntity<Object> getAll() throws Exception {
		return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
	}

}
