package com.che.exceptions;

public class NoSuchBankException extends RuntimeException {
	public NoSuchBankException() {
		super();
	}

	public NoSuchBankException(String message) {
		super(message);
	}

	public NoSuchBankException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchBankException(Throwable cause) {
		super(cause);
	}

	protected NoSuchBankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
