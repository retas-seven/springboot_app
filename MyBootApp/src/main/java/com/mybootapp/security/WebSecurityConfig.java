package com.mybootapp.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(login -> login
                .loginProcessingUrl("/authenticate")
                .usernameParameter("email")
                .passwordParameter("password") // ユーザー名、パスワードのパラメータ名
                .loginPage("/login")
                .defaultSuccessUrl("/menu", true)
                .failureUrl("/login_error")
                .permitAll()
        ).rememberMe( remember -> remember
                .rememberMeParameter("remember-me")
                .tokenValiditySeconds(86400) // 1ヶ月（秒）
        ).logout(logout -> logout
        		.logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies()
        ).authorizeHttpRequests(authz -> authz
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .mvcMatchers(
                	"/",
                	"/login",
                	"/regist/**",
                	"/exec_regist",
            	    "/img/**",
        	        "/css/**",
        	        "/js/**"
                ).permitAll()
                .anyRequest()
                .authenticated()
        );
        return http.build();
    }
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
