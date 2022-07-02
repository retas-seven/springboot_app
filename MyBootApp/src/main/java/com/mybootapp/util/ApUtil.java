package com.mybootapp.util;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mybootapp.dao.AccountDao;
import com.mybootapp.dao.CommonDao;
import com.mybootapp.entity.Account;

@Component
public class ApUtil {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CommonDao commonDao;
	
	/**
	 * ログイン済みであるか判別する。
	 */
	public boolean isAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 登録済メールアドレスであるかチェックする。
	 * @param email メールアドレス
	 * @return 存在する：true, 存在しない：false
	 */
	public boolean existUser(String email) {
		Account a = accountDao.selectByEmail(email);
		if (a == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * システム日付を取得する。
	 * @return
	 */
	public Timestamp selectCurrentTimestamp() {
		return commonDao.selectCurrentTimestamp();
	}
}
