package com.ecom.authorization.server.service;

import com.ecom.authorization.server.exception.JwtTokenExpiredException;
import com.ecom.authorization.server.model.UserCredentials;

public interface UserService {

	public int addUser(UserCredentials user);

	public void validateToken(String token);

	public String generateToken(String username);

	public UserCredentials validateUser(String jwt) throws JwtTokenExpiredException;

}
