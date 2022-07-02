package com.mybootapp.dto.regist;

import lombok.Data;
/**
 * 新規登録画面Form
 */

@Data
public class RegistDto {

    private String companyName;
    
    private String email;
    
    private String empCode;

    private String password;
    
    private String lastnameKana;

    private String firstnameKana;

    private String lastname;

    private String firstname;
}