package com.ecom.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ECOM-API-GATEWAY", url = "http://localhost:8888")
public interface ProductServiceProxy {

	@GetMapping("/product/tests")
	public String testfeign();
}
