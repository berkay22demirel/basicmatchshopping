package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.UserDTO;
import com.example.basicmatchshopping.entity.User;
import com.example.basicmatchshopping.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO create(UserDTO userDTO) {
		User user = convertToEntity(userDTO);
		return convertToDTO(userRepository.save(user));
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		User user = convertToEntity(userDTO);
		return convertToDTO(userRepository.save(user));
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserDTO> getAll() {
		return convertToDTOs(userRepository.findAll());
	}

	private User convertToEntity(UserDTO userDTO) {
		return modelMapper.map(userDTO, User.class);
	}

	private UserDTO convertToDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}

	private List<UserDTO> convertToDTOs(Iterable<User> users) {
		List<UserDTO> userDTOs = new ArrayList<>();
		for (User user : users) {
			userDTOs.add(convertToDTO(user));
		}
		return userDTOs;
	}

}
