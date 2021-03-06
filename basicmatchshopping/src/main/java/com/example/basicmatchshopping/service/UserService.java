package com.example.basicmatchshopping.service;

import java.util.List;

import com.example.basicmatchshopping.dto.UserDTO;

public interface UserService {

	public UserDTO create(UserDTO userDTO);

	public void update(UserDTO userDTO);

	public void delete(int id);

	public List<UserDTO> getAll();

	public UserDTO getByUsername(String username);

}
