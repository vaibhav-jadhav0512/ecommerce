package com.ecom.authorization.server.repository.queries;

public class UserQueries {

	public static final String ADD_USER = "INSERT INTO auth.`user` "
			+ "(email, first_name, last_name, mobile, password, created_dt) "
			+ "VALUES(:email,:firstName,:lastName,:mobile,:password, CURRENT_TIMESTAMP)";
	public static final String FIND_BY_NAME = "SELECT userId, first_name,last_name, email, password,role,mobile "
			+ "FROM auth.`user` WHERE email=:name";
	public static final String FIND_BY_EMAIL = "SELECT userId, first_name,last_name, email, password,role,mobile "
			+ "FROM auth.`user` WHERE email=:email";

}
