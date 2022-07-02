package com.mybootapp.service.regist;

import java.sql.Timestamp;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mybootapp.constant.Role;
import com.mybootapp.dao.AccountDao;
import com.mybootapp.dao.CompanyDao;
import com.mybootapp.dao.SequenceDao;
import com.mybootapp.dto.regist.RegistDto;
import com.mybootapp.entity.Account;
import com.mybootapp.entity.Company;
import com.mybootapp.util.ApUtil;

@Service
public class RegistService {

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	SequenceDao sequenceDao;
	
	@Autowired
	ApUtil apUtil;
	
	/**
	 * 新規登録処理
	 */
	public void regist(RegistDto registDto) {
        // 既に登録されているメールアドレスかチェック
    	if (apUtil.existUser(registDto.getEmail())) {
    		throw new RuntimeException("既に登録されているメールアドレスです。");
    	}
    	Integer nextCompanyId = sequenceDao.selectNextCompanyId();
    	registCompany(registDto.getCompanyName(), nextCompanyId);
    	registAccount(registDto, nextCompanyId);
	}

	/**
	 * 会社情報を登録する
	 * @param companyName
	 * @param nextCompanyId
	 */
	private void registCompany(String companyName, Integer nextCompanyId) {
		Company company = new Company();
		
		company.setCompanyId(nextCompanyId);
		company.setCompanyName(companyName);
		company.setRegistUserId(0);
		company.setRegistDate(new Timestamp(System.currentTimeMillis()));
		company.setUpdateUserId(0);
		company.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		companyDao.insert(company);
	}
	
	/**
	 * アカウント情報を登録する
	 * @param registDto
	 * @param nextCompanyId
	 */
	private void registAccount(RegistDto registDto, Integer nextCompanyId) {
		Account account = new Account();
		BeanUtils.copyProperties(registDto, account);
		
		// copyPropertiesでコピーした項目以外の設定
		account.setCompanyId(nextCompanyId);
		account.setPassword(new BCryptPasswordEncoder().encode(registDto.getPassword())); // パスワードのハッシュ化
		account.setRoleId(Role.ADMIN.toString()); // 新規登録者には管理者権限を設定
		account.setRegistUserId(0);
		account.setRegistDate(new Timestamp(System.currentTimeMillis()));
		account.setUpdateUserId(0);
		account.setUpdateDate(new Timestamp(System.currentTimeMillis()));
		
		accountDao.insert(account);	
	}
}
