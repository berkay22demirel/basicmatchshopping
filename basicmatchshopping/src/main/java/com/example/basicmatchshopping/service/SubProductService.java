package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.SubProductDTO;

public interface SubProductService {

	public int create(SubProductDTO subProductDTO);

	public void update(SubProductDTO subProductDTO);

	public void delete(int id);

	public List<SubProductDTO> getAll();

}
