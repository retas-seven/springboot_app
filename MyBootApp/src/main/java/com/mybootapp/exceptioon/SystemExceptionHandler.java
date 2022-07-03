package com.mybootapp.exceptioon;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SystemExceptionHandler {

	/**
	 * システムエラーのハンドリング。
	 * @param session
	 * @return システムエラー画面パス
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SystemException.class)
	public String handleException(HttpSession session) {
		session.invalidate();
		return "/error";
	}
}
