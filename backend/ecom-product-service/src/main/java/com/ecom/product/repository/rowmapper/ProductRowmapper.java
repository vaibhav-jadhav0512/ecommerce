package com.ecom.product.repository.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ecom.product.model.Product;

public class ProductRowmapper implements RowMapper<Product> {
	public ProductRowmapper() {
	}

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getInt("product_id"));
		product.setProductName(rs.getString("product_name"));
		product.setPrice(rs.getDouble("price"));
		product.setQuantity(rs.getInt("quantity"));
		return product;
	}


}
