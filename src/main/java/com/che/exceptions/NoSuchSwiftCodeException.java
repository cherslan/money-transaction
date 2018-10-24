package com.che.exceptions;

public class NoSuchSwiftCodeException extends RuntimeException {
	public NoSuchSwiftCodeException() {
		super();
	}

	public NoSuchSwiftCodeException(String message) {
		super(message);
	}

	public NoSuchSwiftCodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchSwiftCodeException(Throwable cause) {
		super(cause);
	}

	protected NoSuchSwiftCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
