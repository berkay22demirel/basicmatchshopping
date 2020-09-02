package com.example.basicmatchshopping.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.basicmatchshopping.dto.UserDTO;
import com.example.basicmatchshopping.entity.User;
import com.example.basicmatchshopping.repository.UserRepository;
import com.example.basicmatchshopping.util.MapperUtil;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<User> users = userRepository.findByUserName(username);
		if (CollectionUtils.isEmpty(users)) {
			throw new UsernameNotFoundException(username);
		}
		User user = users.iterator().next();
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	@Override
	public UserDTO getByUsername(String username) {
		return MapperUtil.convertToUserDTO(userRepository.findByUserName(username).iterator().next());
	}

}
