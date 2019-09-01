package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer saveUser(User user) {
		return (Integer)ht.save(user);
		
	}
	@Override
	public User getOneUserByEmail(String email) {
		User usr=null; 
		//SQL:select * from user where email=?
		String hql="from com.app.model.User where userEmail=?0";
		List<User> list=(List<User>) ht.find(hql, email);
		if(list!=null && !list.isEmpty()) {
			usr=list.get(0);
		}
		return usr;
	}
}







