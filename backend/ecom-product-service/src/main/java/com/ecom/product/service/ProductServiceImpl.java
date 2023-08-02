package com.ecom.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.model.Product;
import com.ecom.product.repository.ProductDao;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public int addProduct(ProductDto dto) {
		log.info("Creating product: {}", dto.toString());
		Product product = Product.builder().productName(dto.getProductName()).price(dto.getPrice())
				.quantity(dto.getQuantity()).build();
		return productDao.addProduct(product);
	}

}
