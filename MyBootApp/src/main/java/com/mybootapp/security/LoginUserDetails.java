package com.mybootapp.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mybootapp.entity.Account;

public class LoginUserDetails implements UserDetails {
	
	private final Account account;
	private final Collection<GrantedAuthority> authorities;

	public LoginUserDetails(Account account, Collection<GrantedAuthority> authorities) {
    	this.account = account;
    	this.authorities = authorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
      return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
      return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }

    @Override
	public String getUsername() {
		return account.getLastname() + " " + account.getFirstname();
	}

    @Override
	public String getPassword() {
		return account.getPassword();
	}
    
	public String getEmail() {
		return account.getEmail();
	}
	
	public String getUsernameKana() {
		return account.getLastnameKana() + " " + account.getFirstnameKana();
	}

}