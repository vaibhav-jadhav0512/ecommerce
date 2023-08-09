package com.ecom.authorization.server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {

	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	@JsonIgnore
	private String password;
	private String mobile;
	@JsonIgnore
	private String role;
}
