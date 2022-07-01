package com.mybootapp.form.regist;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mybootapp.util.ApUtil;

@Component
public class RegistFormValidator implements Validator {
	
	@Autowired
	ApUtil apUtil;
	
    @Override
    public boolean supports(Class<?> clazz) {
        return RegistForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	RegistForm form = (RegistForm) target;
    	validatePassword(form, errors);
    	validateExistUser(form, errors);
    }
    
    /**
     * パスワードと確認用パスワードの入力チェック。
     */
    private void validatePassword(RegistForm form, Errors errors) {
        if (errors.hasFieldErrors("password") || errors.hasFieldErrors("confirmPassword")) {
            return;
        }

    	// 未入力チェック
    	if (StringUtils.isEmpty(form.getPassword())) {
    		errors.rejectValue("password", "passwordEmpty.message");
    		return;
    	}
    	if (StringUtils.isEmpty(form.getConfirmPassword())) {
    		errors.rejectValue("confirmPassword", "passwordEmpty.message");
    		return;
    	}
    	
    	// パスワードの一致チェック
    	if (!StringUtils.equals(form.getPassword(), form.getConfirmPassword())) {
    		errors.rejectValue("confirmPassword", "passwordMismatch.message");
    	}
    }
    
    /**
     * メールアドレスの入力チェック。
     */
    private void validateExistUser(RegistForm form, Errors errors) {
        if (errors.hasFieldErrors("email")) {
            return;
        }
        
        // 既に登録されているメールアドレスかチェック
    	if (apUtil.existUser(form.getEmail())) {
    		errors.rejectValue("email", "alreadyRegisteredEmail.message");
    	}
    }
}
