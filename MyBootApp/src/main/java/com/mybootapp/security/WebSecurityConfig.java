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
                .failureUrl("/login?error")
                .permitAll()
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
                	"/regist",
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
	
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	LoginUserDetailsService loginUserDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//    	//パスワードの暗号化方式を設定
//    	return new BCryptPasswordEncoder();
//    	// return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
//    }
//    
//	@Autowired
//	public void configureAuthenticationManager (AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
//	}
//	
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//    	super.configure(web);
//    	
//        // セキュリティ設定を無視するリクエスト設定
//        // 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
//        web.ignoring().antMatchers(
//	        "/img/**",
//	        "/css/**",
//	        "/js/**"
//        );
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    	super.configure(http);
//    	
//        // アクセス制限の設定
//        http.authorizeRequests()
//        	.antMatchers("/")
////            .antMatchers("/", "/login")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//		
//        // ログイン設定
//        .formLogin()
//        	.loginPage("/login") // ログイン画面へ遷移する処理のパス
//            .loginProcessingUrl("/authenticate") // 認証処理のパス
//            .usernameParameter("email")
//            .passwordParameter("password") // ユーザー名、パスワードのパラメータ名
//            .permitAll()
//            .defaultSuccessUrl("/menu", true) // 認証成功時の遷移先
//            .failureUrl("/login")
//            .and()
//            
//        // ログアウト設定
//        .logout()
//        	.logoutUrl("/logout")
//            .logoutSuccessUrl("/") // ログアウト完了時のURL
//            .invalidateHttpSession(true)
//            .deleteCookies()
//            .permitAll();
//    }
}
