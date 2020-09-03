package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.ResultDTO;
import com.example.basicmatchshopping.dto.ShoppingCartItemDTO;
import com.example.basicmatchshopping.service.ShoppingCartItemService;

@RestController
@RequestMapping("/shoppingcartitem")
public class ShoppingCartItemController {

	@Autowired
	private ShoppingCartItemService shoppingCartItemService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Object> add(@RequestBody ShoppingCartItemDTO shoppingCartItem) throws Exception {
		ShoppingCartItemDTO shoppingCartItemDTO = shoppingCartItemService.add(shoppingCartItem);
		return new ResponseEntity<>(shoppingCartItemDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody ShoppingCartItemDTO shoppingCartItem) throws Exception {
		shoppingCartItemService.update(shoppingCartItem);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setResult("ShoppingCartItem is updated successsfully");
		return new ResponseEntity<>(resultDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		shoppingCartItemService.delete(id);
		ResultDTO resultDTO = new ResultDTO();
		resultDTO.setResult("ShoppingCartItem is deleted successsfully");
		return new ResponseEntity<>(resultDTO, HttpStatus.OK);
	}

}
