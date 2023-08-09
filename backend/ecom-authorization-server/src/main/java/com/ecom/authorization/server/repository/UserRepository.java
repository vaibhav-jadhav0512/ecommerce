package com.ecom.authorization.server.repository;

import java.util.Optional;

import com.ecom.authorization.server.model.UserCredentials;

public interface UserRepository {

	public int addUser(UserCredentials user);

	public Optional<UserCredentials> findByName(String username);

}
