package com.che.exceptions;

public class NoSuchBankBranchException extends RuntimeException {
	public NoSuchBankBranchException() {
		super();
	}

	public NoSuchBankBranchException(String message) {
		super(message);
	}

	public NoSuchBankBranchException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchBankBranchException(Throwable cause) {
		super(cause);
	}

	protected NoSuchBankBranchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
