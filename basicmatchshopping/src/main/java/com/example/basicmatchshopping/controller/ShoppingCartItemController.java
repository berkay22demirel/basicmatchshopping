package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.ShoppingCartItemDTO;
import com.example.basicmatchshopping.service.ShoppingCartItemService;

@RestController
@RequestMapping("/shoppingcartitem")
public class ShoppingCartItemController {

	@Autowired
	private ShoppingCartItemService shoppingCartItemService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> add(@RequestBody ShoppingCartItemDTO shoppingCartItem) throws Exception {
		int id = shoppingCartItemService.add(shoppingCartItem);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ShoppingCartItemDTO shoppingCartItem) throws Exception {
		shoppingCartItemService.update(shoppingCartItem);
		return new ResponseEntity<>("ShoppingCartItem is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		shoppingCartItemService.delete(id);
		return new ResponseEntity<>("ShoppingCartItem is deleted successsfully", HttpStatus.OK);
	}

}
