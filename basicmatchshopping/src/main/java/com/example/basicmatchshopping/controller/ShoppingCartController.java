package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.ShoppingCartDTO;
import com.example.basicmatchshopping.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody ShoppingCartDTO shoppingCart) throws Exception {
		int id = shoppingCartService.create(shoppingCart);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ShoppingCartDTO shoppingCart) throws Exception {
		shoppingCartService.update(shoppingCart);
		return new ResponseEntity<>("ShoppingCart is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		shoppingCartService.delete(id);
		return new ResponseEntity<>("ShoppingCart is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getall")
	public ResponseEntity<Object> getAll() throws Exception {
		return new ResponseEntity<>(shoppingCartService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getactivebyuserid/{id}}")
	public ResponseEntity<Object> getActiveShoppingCartByUserId(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>("FIXME", HttpStatus.OK);
	}

}
