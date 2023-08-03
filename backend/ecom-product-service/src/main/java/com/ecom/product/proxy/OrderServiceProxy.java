package com.ecom.product.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ECOM-ORDER-SERVICE/orders")
public interface OrderServiceProxy {

	@GetMapping("/test")
	public String test();
}
