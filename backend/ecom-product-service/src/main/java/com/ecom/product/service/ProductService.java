package com.ecom.product.service;

import java.util.List;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public int addProduct(ProductDto dto);

}
