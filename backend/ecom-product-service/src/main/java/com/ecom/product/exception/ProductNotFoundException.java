package com.ecom.product.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3651820780272533893L;
	private Object[] args;

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(Object[] args) {
		super();
		this.args = args;
	}

	public ProductNotFoundException(String message, Object[] args) {
		super(message);
		this.args = args;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
}
