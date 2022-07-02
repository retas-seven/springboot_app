package com.mybootapp.controller.regist;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybootapp.dao.AccountDao;
import com.mybootapp.dto.regist.RegistDto;
import com.mybootapp.form.regist.RegistForm;
import com.mybootapp.form.regist.RegistFormValidator;
import com.mybootapp.service.regist.RegistService;


@Controller
@RequestMapping("regist")
public class RegistController {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	RegistService registService;
	
	@Autowired
	private RegistFormValidator registFormValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(registFormValidator);
    }
    
	/**
	 * ユーザ登録機能Formをセッションに登録する。
	 * @return 新規登録画面Form
	 */
	@ModelAttribute(value = "registForm")
	public RegistForm setUpRegistForm() {
		RegistForm registForm = new RegistForm();
		
		// TODO テスト用
		registForm.setLastnameKana("タナカ");
		registForm.setFirstnameKana("イチロウ");
		registForm.setLastname("田中");
		registForm.setFirstname("一郎");
		
		return registForm;
	}
	
	/**
	 * 新規登録画面表示
	 * @return 新規登録画面パス
	 */
	@GetMapping(value="")
	public String regist() {
		return "regist/input";
	}

	/**
	 * 新規登録処理実行
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="exec_regist", method=RequestMethod.POST)
	public String execRegist(@Validated RegistForm registForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "regist/input";
        }
        
		RegistDto registDto = new RegistDto();
		BeanUtils.copyProperties(registForm, registDto);
		// 新規登録
		registService.regist(registDto);
		
		return "index";
	}
	
}
