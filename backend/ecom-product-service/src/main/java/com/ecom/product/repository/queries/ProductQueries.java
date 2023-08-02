package com.ecom.product.repository.queries;

public class ProductQueries {

	public static final String GET_ALL_PRODUCTS = "SELECT product_id, product_name, price, quantity "
			+ "FROM product.product";
	public static final String ADD_PRODUCT = "INSERT INTO product.product  (product_name, price, quantity) "
			+ "VALUES(:productName,:price,:quantity)";

}
