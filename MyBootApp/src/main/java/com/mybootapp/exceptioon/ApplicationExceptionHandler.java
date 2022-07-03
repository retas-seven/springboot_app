package com.mybootapp.exceptioon;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationExceptionHandler {

	/**
	 * アプリケーションエラーのハンドリング。
	 * @param session
	 * @param e
	 * @return アプリケーションエラーパス
	 */
    @ExceptionHandler(ApplicationException.class)
	public ModelAndView handleException(HttpSession session, ApplicationException e) {
		session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("applicationErrorMessage", e.getApplicationErrorMessage());
        modelAndView.setViewName("/notice");
        
        return modelAndView;
	}
}
