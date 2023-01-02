package com.example.v1.exception;

public enum ExceptionMessages {
	NOT_SUPPORTED_OPERATION_EXCEPTION("지원하지 않는 연산입니다. {}");
	
	private final String message;
	ExceptionMessages(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
