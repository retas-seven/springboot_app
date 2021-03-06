package com.mybootapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mybootapp.util.ApUtil;


@Controller
public class IndexController {
	
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

	/**
	 * ログイン画面へ遷移する。ログインエラー時に実行される。
	 * @param model
	 * @return ログイン画面パス
	 */
    @GetMapping("/login_error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMsg", apUtil.getMessage("loginError"));
        return "login";
    }
    
	/**
	 * メニュー画面表示
	 * @return メニュー画面パス
	 */
	@RequestMapping(value="menu")
	public String menu() {
		return "menu";
	}
}
