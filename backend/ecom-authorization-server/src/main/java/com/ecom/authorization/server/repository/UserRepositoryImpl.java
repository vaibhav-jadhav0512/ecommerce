package com.ecom.authorization.server.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ecom.authorization.server.model.UserCredentials;
import com.ecom.authorization.server.repository.queries.UserQueries;
import com.ecom.authorization.server.repository.rowmapper.UserRowMapper;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	@Override
	public int addUser(UserCredentials user) {
		Map<String, Object> paramMap = new HashMap<>();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		paramMap.put("firstName", user.getFirstName());
		paramMap.put("lastName", user.getLastName());
		paramMap.put("email", user.getEmail());
		paramMap.put("password", user.getPassword());
		paramMap.put("mobile", user.getMobile());
		template.update(UserQueries.ADD_USER, new MapSqlParameterSource(paramMap), keyHolder);
		log.info("Product created:{} with id:{}", user.toString(), keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}

	@Override
	public Optional<UserCredentials> findByName(String username) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", username);
		try {
			UserCredentials user = template.queryForObject(UserQueries.FIND_BY_NAME, paramMap, new UserRowMapper());
			log.info("Found user:{}", user.toString());
			return Optional.ofNullable(user);
		} catch (EmptyResultDataAccessException ex) {
			return Optional.empty();
		}
	}

	@Override
	public UserCredentials findByEmail(String email) {
		log.info("Finding by email: {}", email);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		return template.queryForObject(UserQueries.FIND_BY_EMAIL, paramMap, new UserRowMapper());
	}

}
