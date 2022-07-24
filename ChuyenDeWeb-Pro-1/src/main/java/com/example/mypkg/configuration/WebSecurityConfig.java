package com.example.mypkg.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.example.mypkg.service.imp.UserDetailsServiceImp;
import com.example.mypkg.until.Message;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImp userDetailsService;
	@Autowired
	private AppConfig appConfig;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		http.authorizeRequests().antMatchers("/logout").permitAll();

		http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

		http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().and().formLogin().loginProcessingUrl("/security_check_login").loginPage("/dangnhap")
				.defaultSuccessUrl("/").failureUrl("/dangnhap?error=" + Message.MS_LOGIN_FAILED.get())
				.usernameParameter("email").passwordParameter("password").and().logout().logoutUrl("/logout")
				.logoutSuccessUrl("/dangnhap");

	}
}
