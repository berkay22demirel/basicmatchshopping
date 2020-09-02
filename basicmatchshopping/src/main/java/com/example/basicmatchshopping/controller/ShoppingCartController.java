package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.service.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@RequestMapping(value = "/getactivebyuserid/{id}")
	public ResponseEntity<Object> getActiveShoppingCartByUserId(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>(shoppingCartService.getActiveShoppingCartByUserId(id), HttpStatus.OK);
	}

}
