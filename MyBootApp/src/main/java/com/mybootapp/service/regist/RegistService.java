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
	 * 新規登録処理。
	 * @param registDto
	 */
	public void regist(RegistDto registDto) {
    	Integer nextCompanyId = sequenceDao.selectNextCompanyId();
    	Timestamp currentTimestamp = apUtil.selectCurrentTimestamp();
    	registCompany(registDto.getCompanyName(), nextCompanyId, currentTimestamp);
    	registAccount(registDto, nextCompanyId, currentTimestamp);
	}

	/**
	 * 会社情報を登録する。
	 * @param companyName
	 * @param nextCompanyId
	 */
	private void registCompany(String companyName, Integer nextCompanyId, Timestamp currentTimestamp) {
		Company company = new Company();
		
		company.setCompanyId(nextCompanyId);
		company.setCompanyName(companyName);
		company.setRegistUserId(0);
		company.setRegistDate(currentTimestamp);
		company.setUpdateUserId(0);
		company.setUpdateDate(currentTimestamp);
		
		companyDao.insert(company);
	}
	
	/**
	 * アカウント情報を登録する。
	 * @param registDto
	 * @param nextCompanyId
	 */
	private void registAccount(RegistDto registDto, Integer nextCompanyId, Timestamp currentTimestamp) {
		Account account = new Account();
		BeanUtils.copyProperties(registDto, account);
		
		// copyPropertiesでコピーした項目以外の設定
		account.setCompanyId(nextCompanyId);
		account.setPassword(new BCryptPasswordEncoder().encode(registDto.getPassword())); // パスワードのハッシュ化
		account.setRoleId(Role.ADMIN.toString()); // 新規登録者には管理者権限を設定
		account.setRegistUserId(0);
		account.setRegistDate(currentTimestamp);
		account.setUpdateUserId(0);
		account.setUpdateDate(currentTimestamp);
		
		accountDao.insert(account);	
	}
}
