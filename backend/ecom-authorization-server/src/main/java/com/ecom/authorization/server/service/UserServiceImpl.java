package com.ecom.authorization.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.authorization.server.model.UserCredentials;
import com.ecom.authorization.server.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@Override
	public int addUser(UserCredentials user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.addUser(user);
	}

	@Override
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}

	@Override
	public void validateToken(String token) {
		jwtService.validateToken(token);
	}

}
