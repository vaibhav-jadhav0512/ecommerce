package com.ecom.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.order.proxy.ProductServiceProxy;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private ProductServiceProxy productServiceProxy;

//	@PreAuthorize("hasAuthority('Admin') || hasAuthority('Customer') || hasAuthority('SCOPE_internal') || hasAuthority('SCOPE_profile')")
	@GetMapping("/test")
	public String test() {
		return "Order";
//		return productServiceProxy.testfeign();
	}
}
