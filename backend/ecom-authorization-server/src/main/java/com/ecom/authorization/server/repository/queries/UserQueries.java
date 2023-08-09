package com.ecom.authorization.server.repository.queries;

public class UserQueries {

	public static final String ADD_USER = "INSERT INTO auth.`user` (name, email, password) "
			+ "VALUES(:name, :email, :password)";
	public static final String FIND_BY_NAME = "SELECT userId, name, email, password "
			+ "FROM auth.`user` WHERE email=:name";

}
