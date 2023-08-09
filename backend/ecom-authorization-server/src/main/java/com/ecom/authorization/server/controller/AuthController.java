package com.ecom.authorization.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.authorization.server.model.AuthRequest;
import com.ecom.authorization.server.model.UserCredentials;
import com.ecom.authorization.server.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/auth")
@Log4j2
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	private UserService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/register")
	public ResponseEntity<Integer> addNewUser(@RequestBody UserCredentials user) {
		return new ResponseEntity<>(service.addUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest) {
		log.info("User:{}", authRequest.toString());
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return service.generateToken(authRequest.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}
	}

	@GetMapping("/user")
	public ResponseEntity<UserCredentials> validateUser(@RequestHeader("Authorization") String jwt) {
		return new ResponseEntity<>(service.validateUser(jwt), HttpStatus.OK);
	}
}
