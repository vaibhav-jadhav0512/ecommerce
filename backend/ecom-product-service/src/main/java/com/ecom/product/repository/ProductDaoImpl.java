package com.ecom.product.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecom.product.model.Product;
import com.ecom.product.repository.queries.ProductQueries;
import com.ecom.product.repository.rowmapper.ProductRowmapper;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Product> getAllProducts() {
		Map<String, Object> paramMap = new HashMap<>();
		return jdbcTemplate.query(ProductQueries.GET_ALL_PRODUCTS, paramMap, new ProductRowmapper());
	}

}
