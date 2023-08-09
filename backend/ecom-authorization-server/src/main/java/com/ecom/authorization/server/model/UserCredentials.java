package com.ecom.authorization.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {

	private Long userId;
	private String name;
	private String email;
	private String password;
}
