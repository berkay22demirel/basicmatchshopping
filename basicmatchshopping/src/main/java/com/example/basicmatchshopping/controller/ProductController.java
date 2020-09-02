package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.ProductDTO;
import com.example.basicmatchshopping.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody ProductDTO product) throws Exception {
		int id = productService.create(product);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ProductDTO product) throws Exception {
		productService.update(product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		productService.delete(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getall")
	public ResponseEntity<Object> getAll() throws Exception {
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getallbycategoryid/{id}")
	public ResponseEntity<Object> getAllByCategoryId(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>(productService.findProductsByCategoryId(id), HttpStatus.OK);
	}

}
