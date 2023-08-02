package com.ecom.product.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ecom.product.model.Product;
import com.ecom.product.repository.queries.ProductQueries;
import com.ecom.product.repository.rowmapper.ProductRowmapper;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class ProductDaoImpl implements ProductDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() {
		Map<String, Object> paramMap = new HashMap<>();
		return jdbcTemplate.query(ProductQueries.GET_ALL_PRODUCTS, paramMap, new ProductRowmapper());
	}

	@Override
	public int addProduct(Product product) {
		Map<String, Object> paramMap = new HashMap<>();
		KeyHolder keyHolder = new GeneratedKeyHolder();
		paramMap.put("productName", product.getProductName());
		paramMap.put("price", product.getPrice());
		paramMap.put("quantity", product.getQuantity());
		jdbcTemplate.update(ProductQueries.ADD_PRODUCT, new MapSqlParameterSource(paramMap), keyHolder);
		return keyHolder.getKey().intValue();
	}

}
