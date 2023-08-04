package com.ecom.product.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ECOM-API-GATEWAY", url = "http://localhost:8888", fallback = OrderServiceFallback.class)
public interface OrderServiceProxy {

	@GetMapping("/orders/test")
	public String test();
}
