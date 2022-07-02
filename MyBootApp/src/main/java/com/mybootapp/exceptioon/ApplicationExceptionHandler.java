package com.mybootapp.exceptioon;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApplicationExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(ApplicationExceptionHandler.class);
	
    @ExceptionHandler(ApplicationException.class)
	public ModelAndView handleException(HttpSession session, ApplicationException e) {
		session.invalidate();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errMsg", e.getErrMsg());
        modelAndView.setViewName("/notice");
        
        return modelAndView;
	}
}
