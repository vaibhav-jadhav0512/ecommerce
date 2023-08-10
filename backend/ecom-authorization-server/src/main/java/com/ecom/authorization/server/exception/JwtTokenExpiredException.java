package com.ecom.authorization.server.exception;

public class JwtTokenExpiredException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6455597962602118633L;
	/**
	 * 
	 */
	private Object[] args;

	public JwtTokenExpiredException(String message) {
		super(message);
	}

	public JwtTokenExpiredException(Object[] args) {
		super();
		this.args = args;
	}

	public JwtTokenExpiredException(String message, Object[] args) {
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