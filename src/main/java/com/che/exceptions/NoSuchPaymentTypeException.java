package com.che.exceptions;

import org.omg.SendingContext.RunTime;

public class NoSuchPaymentTypeException extends RuntimeException {
	public NoSuchPaymentTypeException() {
		super();
	}

	public NoSuchPaymentTypeException(String message) {
		super(message);
	}

	public NoSuchPaymentTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchPaymentTypeException(Throwable cause) {
		super(cause);
	}

	protected NoSuchPaymentTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
