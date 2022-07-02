package com.mybootapp.exceptioon;

public class ApplicationException extends RuntimeException {
	private String errMsg;

	@SuppressWarnings("unused")
	private ApplicationException() {}

	public ApplicationException(String errMsg) {
		super();
		this.errMsg = errMsg;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
