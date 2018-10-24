package com.che.exceptions;

public class NoSuchAccountException extends RuntimeException {
	public NoSuchAccountException() {
		super();
	}

	public NoSuchAccountException(String message) {
		super(message);
	}

	public NoSuchAccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchAccountException(Throwable cause) {
		super(cause);
	}

	protected NoSuchAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
