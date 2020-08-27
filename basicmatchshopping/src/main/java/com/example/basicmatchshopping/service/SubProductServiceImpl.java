package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.SubProductDTO;
import com.example.basicmatchshopping.entity.SubProduct;
import com.example.basicmatchshopping.repository.SubProductRepository;

@Service
public class SubProductServiceImpl implements SubProductService {

	@Autowired
	private SubProductRepository subProductRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SubProductDTO create(SubProductDTO subProductDTO) {
		SubProduct subProduct = convertToEntity(subProductDTO);
		return convertToDTO(subProductRepository.save(subProduct));
	}

	@Override
	public SubProductDTO update(SubProductDTO subProductDTO) {
		SubProduct subProduct = convertToEntity(subProductDTO);
		return convertToDTO(subProductRepository.save(subProduct));
	}

	@Override
	public void delete(int id) {
		subProductRepository.deleteById(id);
	}

	@Override
	public List<SubProductDTO> getAll() {
		return convertToDTOs(subProductRepository.findAll());
	}

	private SubProduct convertToEntity(SubProductDTO subProductDTO) {
		return modelMapper.map(subProductDTO, SubProduct.class);
	}

	private SubProductDTO convertToDTO(SubProduct subProduct) {
		return modelMapper.map(subProduct, SubProductDTO.class);
	}

	private List<SubProductDTO> convertToDTOs(Iterable<SubProduct> subProducts) {
		List<SubProductDTO> subProductDTOs = new ArrayList<>();
		for (SubProduct subProduct : subProducts) {
			subProductDTOs.add(convertToDTO(subProduct));
		}
		return subProductDTOs;
	}

}
