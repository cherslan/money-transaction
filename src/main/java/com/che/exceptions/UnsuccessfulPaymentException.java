package com.che.exceptions;

public class UnsuccessfulPaymentException extends RuntimeException {

	public UnsuccessfulPaymentException() {
		super();
	}

	public UnsuccessfulPaymentException(String message) {
		super(message);
	}

	public UnsuccessfulPaymentException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsuccessfulPaymentException(Throwable cause) {
		super(cause);
	}
}
