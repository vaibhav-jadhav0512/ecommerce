package com.ecom.product.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ECOM-ORDER-SERVICE", fallback = OrderServiceFallback.class)
public interface OrderServiceProxy {

	@GetMapping("/orders/test")
	public String test();
}
