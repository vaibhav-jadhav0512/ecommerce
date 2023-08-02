package com.ecom.product.model;

import lombok.Data;

@Data
public class Product {

	private int productId;
	private String productName;
	private double price;
	private int quantity;
}
