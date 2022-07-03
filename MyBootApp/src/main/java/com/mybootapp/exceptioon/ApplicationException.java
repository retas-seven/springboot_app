package com.mybootapp.exceptioon;

public class ApplicationException extends RuntimeException {
	private String applicationErrorMessage;

	@SuppressWarnings("unused")
	private ApplicationException() {}

	public ApplicationException(String applicationErrorMessage) {
		super();
		this.applicationErrorMessage = applicationErrorMessage;
	}

	public String getApplicationErrorMessage() {
		return applicationErrorMessage;
	}

	public void setApplicationErrorMessage(String applicationErrorMessage) {
		this.applicationErrorMessage = applicationErrorMessage;
	}
}
