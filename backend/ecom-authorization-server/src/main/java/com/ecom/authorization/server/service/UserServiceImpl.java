package com.ecom.authorization.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecom.authorization.server.exception.JwtTokenExpiredException;
import com.ecom.authorization.server.model.UserCredentials;
import com.ecom.authorization.server.repository.UserRepository;

import io.jsonwebtoken.ExpiredJwtException;

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

	@Override
	public UserCredentials validateUser(String jwt) throws JwtTokenExpiredException {
		try {
		String email = jwtService.getEmailFromJwtToken(jwt);
		return userRepository.findByEmail(email);
	} catch (ExpiredJwtException e) {
		throw new JwtTokenExpiredException("JWT token is expired");
	}
	}

}
