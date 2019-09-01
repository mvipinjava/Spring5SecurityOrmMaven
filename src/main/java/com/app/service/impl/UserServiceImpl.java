package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	/***Spring Security code***/
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private IUserDao dao;
	
	@Transactional
	public Integer saveUser(User user) {
		/****
		 * Encoding Password in Service Layer
		 * Before Save Operation
		 */
		//read UI Pwd
		String pwd=user.getUserPwd();
		//encode
		String encPwd=encoder.encode(pwd);
		//set back to Object
		user.setUserPwd(encPwd);
		
		/**Perform Save and Return PK to UI*/
		return dao.saveUser(user);
	}
}




