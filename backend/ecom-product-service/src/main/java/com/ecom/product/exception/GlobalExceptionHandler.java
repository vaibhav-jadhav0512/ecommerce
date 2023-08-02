package com.ecom.product.exception;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@PropertySource("classpath:errormap.properties")
@Log4j2
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@Autowired
	private Environment env;

	@Autowired
	private MessageSource messageSource;

	private static final String ERROR_CODE = "Error Code: {}";
	private static final String ERROR_MESSAGE = "Error Message: {}";
	private static final String RETURNING_RESPONSE = "Returning ErrorResponse To Client: {}";
	private static final String CAUSE = "Cause: {}";

	@ExceptionHandler(ProductNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleInvalidRegException(ProductNotFoundException ex,
			WebRequest request) {
		log.info("Handling ProductNotFoundException");
		String errorCode = env.getProperty(ExceptionConstantsMap.PRODUCT_NOT_FOUND_EXCEPTION);
		log.info(ERROR_CODE, errorCode);

		String errorMessage = messageSource.getMessage(errorCode, ex.getArgs(), LocaleContextHolder.getLocale());
		log.info(ERROR_MESSAGE, errorMessage);

		ErrorResponse errorResponse = new ErrorResponse(errorCode, Calendar.getInstance().getTime(), "", errorMessage,
				"Product Not Found");

		log.info(RETURNING_RESPONSE, errorResponse);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
