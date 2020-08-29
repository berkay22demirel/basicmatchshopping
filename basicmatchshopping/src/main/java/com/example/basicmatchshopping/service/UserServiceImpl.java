package com.example.basicmatchshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basicmatchshopping.dto.UserDTO;
import com.example.basicmatchshopping.entity.User;
import com.example.basicmatchshopping.repository.UserRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public int create(UserDTO userDTO) {
		User user = MapperUtil.convertToUser(userDTO);
		return userRepository.save(user).getId();
	}

	@Override
	public void update(UserDTO userDTO) {
		User user = MapperUtil.convertToUser(userDTO);
		userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<UserDTO> getAll() {
		return MapperUtil.convertToUserDTOs(userRepository.findAll());
	}

}
