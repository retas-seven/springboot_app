package com.mybootapp.service.regist;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mybootapp.constant.Role;
import com.mybootapp.dao.AccountDao;
import com.mybootapp.dao.SequenceDao;
import com.mybootapp.dto.regist.RegistDto;
import com.mybootapp.entity.Account;
import com.mybootapp.util.ApUtil;

@Service
public class RegistService {
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	SequenceDao sequenceDao;
	
	@Autowired
	ApUtil apUtil;
	
	/**
	 * 新規ユーザを登録する。
	 */
	public void regist(RegistDto registDto) {
        // 既に登録されているメールアドレスかチェック
    	if (apUtil.existUser(registDto.getEmail())) {
    		throw new RuntimeException("既に登録されているメールアドレスです。");
    	}
		
		Account account = new Account();
		BeanUtils.copyProperties(registDto, account);
		
		// copyPropertiesでコピーした項目以外の設定
		account.setUserId(sequenceDao.selectNextUserId());
		account.setCompanyId(sequenceDao.selectNextCompanyId());
		account.setPassword(new BCryptPasswordEncoder().encode(registDto.getPassword())); // パスワードのハッシュ化
		account.setRoleId(Role.ADMIN.toString()); // 新規登録者には管理者権限を設定
		account.setRegistUserId("system");
		account.setRegistDate(new Timestamp(System.currentTimeMillis()));
		account.setUpdateUserId("system");
		account.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		accountDao.insert(account);
	}
}
