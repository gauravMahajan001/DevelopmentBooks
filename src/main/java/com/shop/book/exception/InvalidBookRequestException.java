package com.shop.book.exception;

public class InvalidBookRequestException extends RuntimeException {

	private static final long serialVersionUID = -90611061074L;

	public InvalidBookRequestException() {
		super();
	}

	public InvalidBookRequestException(final String message) {
		super(message);
	}
}
