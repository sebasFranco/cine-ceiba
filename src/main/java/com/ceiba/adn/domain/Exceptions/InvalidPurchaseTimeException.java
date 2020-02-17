package com.ceiba.adn.domain.Exceptions;

public class InvalidPurchaseTimeException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPurchaseTimeException(String message) {
		super(message);
	}
}
