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
import com.mybootapp.entity.Account;

@Service
@Transactional(readOnly=true)
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountDao accountDao;
	
    @Override
    public LoginUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // ユーザ情報を取得する
    	Account account = accountDao.selectByEmail(email);
        
        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        // 権限情報を取得する
        Collection<GrantedAuthority> authorities = getAuthorities(account);
        
        return new LoginUserDetails(account, authorities);
    }
    
    private Collection<GrantedAuthority> getAuthorities(Account account) {
    	if (Role.isAdmin(account.getRoleId())) {
    		return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
    	} else {
    		return AuthorityUtils.createAuthorityList("ROLE_USER");
    	}
    }
}