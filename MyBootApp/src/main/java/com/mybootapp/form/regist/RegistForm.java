package com.mybootapp.form.regist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

/**
 * 新規登録画面Form
 */
@Data
public class RegistForm {

	@NotEmpty
    private String companyName;
	
	@NotEmpty
	@Email
    private String email;

	@NotEmpty
    private String empCode;
	
	@NotEmpty
    private String password;

	@NotEmpty
    private String confirmPassword;
    
	@NotEmpty
    private String lastnameKana;

	@NotEmpty
    private String firstnameKana;

	@NotEmpty
    private String lastname;

	@NotEmpty
    private String firstname;
}
