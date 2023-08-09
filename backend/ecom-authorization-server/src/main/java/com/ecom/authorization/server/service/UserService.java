package com.ecom.authorization.server.service;

import com.ecom.authorization.server.model.UserCredentials;

public interface UserService {

	public int addUser(UserCredentials user);

	public void validateToken(String token);

	public String generateToken(String username);

}
