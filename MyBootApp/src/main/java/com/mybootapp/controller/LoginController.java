package com.mybootapp.controller;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mybootapp.constant.Role;
import com.mybootapp.dao.AccountDao;
import com.mybootapp.entity.Account;


@Controller
public class LoginController {
	
	@Autowired
	AccountDao accountDao;

	/**
	 * ログイン画面表示
	 * @return ログイン画面パス
	 */
	@GetMapping(value="login")
	public String login(ModelAndView mav) {
		return "login";
	}
	
	/**
	 * 新規登録画面表示
	 * @return 新規登録画面パス
	 */
	@GetMapping(value="regist")
	public String regist(ModelAndView mav) {
		return "regist";
	}
	
	/**
	 * メニュー画面表示
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="menu")
	public String menu() {
		return "app/menu";
	}
	
	/**
	 * 新規登録処理実行
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="exec_regist", method=RequestMethod.POST)
	public String execRegist(@ModelAttribute("email") String email, @ModelAttribute("password") String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encordPassword = encoder.encode(password);
		
		Account a = new Account() {
			{
				setUserId("3"); // 要手動インクリメント
				setEmail(email);
				setCompanyId("0");
				setLastnameKana("タナカ");
				setFirstnameKana("イチロウ");
				setLastname("田中");
				setFirstname("一郎");
				setPassword(encordPassword);
				setRoleId(Role.ADMIN.toString());
				setRegistDate(new Timestamp(System.currentTimeMillis()));
				setRegistUserId("0");
				setUpdateDate(new Timestamp(System.currentTimeMillis()));
				setUpdateUserId("0");
				setVersion(0);
			}
		};
		
		accountDao.insert(a);
		
		return "app/menu";
	}
	
}
