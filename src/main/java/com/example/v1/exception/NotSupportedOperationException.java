package com.example.v1.exception;

import static com.example.v1.exception.ExceptionMessages.NOT_SUPPORTED_OPERATION_EXCEPTION;

public class NotSupportedOperationException extends RuntimeException {

	public NotSupportedOperationException(String express) {
		super(String.format(NOT_SUPPORTED_OPERATION_EXCEPTION.getMessage(), express));
	}
}
