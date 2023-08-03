package com.ecom.product.proxy;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Component;

import feign.RetryableException;
import jakarta.ws.rs.BadRequestException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class OrderServiceFallback implements FallbackFactory<OrderServiceProxy> {

	@Override
	public OrderServiceProxy create(Throwable cause) {
		return new OrderServiceProxy() {

			@Override
			public String test() {
				log.error("Service down");
				if (cause instanceof BadRequestException) {
					return "Bad Request!!!";
				}
				if (cause instanceof NotFoundException) {
					return "Not Found!!!";
				}
				if (cause instanceof Exception) {
					return "Exception!!!";
				}
				if (cause instanceof RetryableException) {
					return "Service down!!!";
				}
				return "Success";
			}

		};
	}

}
