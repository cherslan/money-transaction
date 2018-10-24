package com.che.exceptions;

import org.omg.SendingContext.RunTime;

public class InvalidIbanNumberException extends RuntimeException {
	public InvalidIbanNumberException() {
		super();
	}

	public InvalidIbanNumberException(String message) {
		super(message);
	}

	public InvalidIbanNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidIbanNumberException(Throwable cause) {
		super(cause);
	}

	protected InvalidIbanNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
