package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.SubProductDTO;
import com.example.basicmatchshopping.service.SubProductService;

@RestController
@RequestMapping("/subproduct")
public class SubProductController {

	@Autowired
	private SubProductService subProductService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody SubProductDTO subProduct) throws Exception {
		int id = subProductService.create(subProduct);
		return new ResponseEntity<>(id, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody SubProductDTO subProduct) throws Exception {
		subProductService.update(subProduct);
		return new ResponseEntity<>("SubProduct is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) throws Exception {
		subProductService.delete(id);
		return new ResponseEntity<>("SubProduct is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/getall")
	public ResponseEntity<Object> getAll() throws Exception {
		return new ResponseEntity<>(subProductService.getAll(), HttpStatus.OK);
	}

}
