package com.mybootapp.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybootapp.constant.Role;
import com.mybootapp.dao.AccountDao;
import com.mybootapp.dao.CompanyDao;
import com.mybootapp.entity.Account;
import com.mybootapp.entity.Company;

@Service
@Transactional(readOnly=true)
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountDao accountDao;
    
    @Autowired
    private CompanyDao companyDao;
	
    @Override
    public LoginUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ユーザ情報を取得する
    	Account account = accountDao.selectByEmail(email);
        if (account == null) {
            throw new UsernameNotFoundException("not found");
        }

        // 権限情報を取得する
        Collection<GrantedAuthority> authorities = getAuthorities(account);
        
        // 会社情報を取得する
        Company company = companyDao.selectById(account.getCompanyId());
        if (company == null) {
            throw new UsernameNotFoundException("not found");
        }

        return new LoginUserDetails(account, authorities, company);
    }
    
    private Collection<GrantedAuthority> getAuthorities(Account account) {
    	if (Role.isAdmin(account.getRoleId())) {
    		return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
    	} else {
    		return AuthorityUtils.createAuthorityList("ROLE_USER");
    	}
    }
}