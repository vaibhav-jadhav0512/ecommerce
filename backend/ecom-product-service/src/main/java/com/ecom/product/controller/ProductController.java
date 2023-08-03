package com.ecom.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.product.dto.ProductDto;
import com.ecom.product.model.Product;
import com.ecom.product.proxy.OrderServiceProxy;
import com.ecom.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderServiceProxy orderServiceProxy;

	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Integer> addProduct(@RequestBody ProductDto dto) {
		return new ResponseEntity<>(productService.addProduct(dto), HttpStatus.CREATED);
	}

	@GetMapping("/test")
	public String test() {
		return orderServiceProxy.test();
	}

}
