package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.OrderDTO;
import com.example.basicmatchshopping.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public ResponseEntity<Object> buy(@RequestBody OrderDTO order) throws Exception {
		int id = orderService.buy(order);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/getallbyuserid/{id}")
	public ResponseEntity<Object> getAllByUserId(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>(orderService.getOrdersByUserId(id), HttpStatus.OK);
	}

}
