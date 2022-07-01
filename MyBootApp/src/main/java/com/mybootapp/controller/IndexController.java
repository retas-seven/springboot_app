package com.mybootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybootapp.util.ApUtil;


@Controller
public class IndexController {
	
//	@Autowired
//	AccountDao accountDao;
	@Autowired
	ApUtil apUtil;

	/**
	 * ログイン画面表示
	 * @return ログイン画面パス
	 */
	@GetMapping(value="login")
	public String login() {
		if (apUtil.isAuthenticated()) {
			// ログイン済みのユーザがURL手打ちやブラウザバックでこの処理に入った場合を想定し、メニュー画面へ遷移するようにする。
			return "menu";
		} else {
			return "login";
		}
	}
	
//	/**
//	 * 新規登録画面表示
//	 * @return 新規登録画面パス
//	 */
//	@GetMapping(value="regist")
//	public String regist() {
//		return "regist";
//	}
//	
	/**
	 * メニュー画面表示
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="menu")
	public String menu() {
		return "menu";
	}
	
//	/**
//	 * 新規登録処理実行
//	 * @return メニュー画面パス
//	 */
//	@RequestMapping(value="exec_regist", method=RequestMethod.POST)
//	public String execRegist(@ModelAttribute("email") String email, @ModelAttribute("password") String password) {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encordPassword = encoder.encode(password);
//		
//		Account a = new Account() {
//			{
//				setUserId("4"); // 要手動インクリメント
//				setEmail(email);
//				setCompanyId("0");
//				setLastnameKana("タナカ");
//				setFirstnameKana("イチロウ");
//				setLastname("田中");
//				setFirstname("一郎");
//				setPassword(encordPassword);
//				setRoleId(Role.ADMIN.toString());
//				setRegistDate(new Timestamp(System.currentTimeMillis()));
//				setRegistUserId("0");
//				setUpdateDate(new Timestamp(System.currentTimeMillis()));
//				setUpdateUserId("0");
//				setVersion(0);
//			}
//		};
//		
//		accountDao.insert(a);
//		
//		return "menu";
//	}
	
}
