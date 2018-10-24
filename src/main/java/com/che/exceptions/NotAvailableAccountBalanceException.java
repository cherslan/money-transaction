package com.che.exceptions;

public class NotAvailableAccountBalanceException extends RuntimeException {

	public NotAvailableAccountBalanceException() {
		super();
	}

	public NotAvailableAccountBalanceException(String message) {
		super(message);
	}

	public NotAvailableAccountBalanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotAvailableAccountBalanceException(Throwable cause) {
		super(cause);
	}

	protected NotAvailableAccountBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
