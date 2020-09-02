package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/getallbycategoryid/{id}")
	public ResponseEntity<Object> getAllByCategoryId(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>(productService.findProductsByCategoryId(id), HttpStatus.OK);
	}

}
