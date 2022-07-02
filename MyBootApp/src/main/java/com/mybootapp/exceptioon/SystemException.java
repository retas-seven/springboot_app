package com.mybootapp.exceptioon;

public class SystemException extends RuntimeException {

	public SystemException(Exception e) {
		super(e);
	}

	public SystemException() {
	}

}
