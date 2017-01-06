package com.pranav.exception;

import com.pranav.util.LogMessage;

public class RamseyFoodException extends Exception {

	private static final long serialVersionUID = 1L;

	public RamseyFoodException(final String message) {
		super(message);
		LogMessage.error("*******" + message + "*******");
	}

	public RamseyFoodException(final Exception exception) {
		super(exception);
		LogMessage.error(exception.getMessage(), exception);
	}

	public RamseyFoodException(final Exception exception, final String message) {
		super(message);
		LogMessage.error(exception.getMessage(), exception);
	}
}
