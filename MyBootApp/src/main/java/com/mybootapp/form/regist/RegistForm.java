package com.mybootapp.form.regist;

import lombok.Data;

/**
 * 新規登録画面Form
 */
@Data
public class RegistForm {
	
    private String email;

    private String password;

    private String confirmPassword;
    
    private String lastnameKana;

    private String firstnameKana;

    private String lastname;

    private String firstname;
}
