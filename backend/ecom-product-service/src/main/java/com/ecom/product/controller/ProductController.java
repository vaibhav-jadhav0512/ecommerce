package com.ecom.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.model.Product;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public ResponseEntity<List<Product>> test() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

	}

}
