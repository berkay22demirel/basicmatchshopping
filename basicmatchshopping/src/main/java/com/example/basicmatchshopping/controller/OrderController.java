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

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody OrderDTO order) throws Exception {
		int id = orderService.create(order);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody OrderDTO order) throws Exception {
		orderService.update(order);
		return new ResponseEntity<>("Order is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		orderService.delete(id);
		return new ResponseEntity<>("Order is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getall")
	public ResponseEntity<Object> getAll() throws Exception {
		return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getallbyuserid/{id}")
	public ResponseEntity<Object> getAllByUserId(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>("FIXME", HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") int id) throws Exception {
		return new ResponseEntity<>("FIXME", HttpStatus.OK);
	}

}
