package com.example.basicmatchshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.basicmatchshopping.dto.AuthRequest;
import com.example.basicmatchshopping.dto.TokenDTO;
import com.example.basicmatchshopping.service.AmazonService;
import com.example.basicmatchshopping.service.JwtService;
import com.example.basicmatchshopping.service.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private AmazonService amazonService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<Object> creteToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (BadCredentialsException ex) {
			throw new Exception("Incorret username or password", ex);
		}
		final UserDetails userDetails = userServiceImpl.loadUserByUsername(authRequest.getUsername());
		final String jwt = jwtService.generateToken(userDetails);
		TokenDTO tokenDTO = new TokenDTO();
		tokenDTO.setToken(jwt);

		return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/amazon", method = RequestMethod.GET)
	public ResponseEntity<Object> amazon() throws Exception {
		amazonService.fillProduct();
		return new ResponseEntity<>("Successsfull", HttpStatus.OK);
	}

}
