package com.ecom.authorization.server.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecom.authorization.server.model.UserCredentials;

public class UserRowMapper implements RowMapper<UserCredentials> {
	public UserRowMapper() {
	}

	@Override
	public UserCredentials mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCredentials user = new UserCredentials();
		user.setUserId(rs.getInt("userId"));
		user.setFirstName(rs.getString("first_name"));
		user.setLastName(rs.getString("last_name"));
		user.setMobile(rs.getString("mobile"));
		user.setRole(rs.getString("role"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	}


}
