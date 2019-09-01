package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserDetailsService service;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service)
		.passwordEncoder(encoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/emp/reg","/emp/save").hasAuthority("ADMIN")
		.antMatchers("/emp/all").hasAnyAuthority("ADMIN","MANAGER")
		.antMatchers("/emp/delete","/emp/edit","/emp/update").hasAuthority("MANAGER")
		
		.anyRequest().authenticated()
		
		.and()
		.formLogin()
		.defaultSuccessUrl("/emp/all", true)
		
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		
		
		
		;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
