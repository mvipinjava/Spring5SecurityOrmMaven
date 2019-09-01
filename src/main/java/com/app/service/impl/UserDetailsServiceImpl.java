package com.app.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;

@Service
public class UserDetailsServiceImpl
implements UserDetailsService
{
	@Autowired
	private IUserDao dao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//1. Load Model class user by email
		com.app.model.User user=dao.getOneUserByEmail(username);
		
		//2. Construct roles as GA
		Set<GrantedAuthority> auths=new HashSet<>();
		
		//3. read roles from model class user and set to GA
		Set<String> roles=user.getRoles();
		for(String role:roles) {
			//read Role as String and convert to GA
			GrantedAuthority ga=new SimpleGrantedAuthority(role);
			//add to Set<GA>
			auths.add(ga);
		}
		
		//4. Construct and return Spring User
		return new User(username, user.getUserPwd(), auths);
	}
} 



