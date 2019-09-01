package com.app.dao;

import com.app.model.User;

public interface IUserDao {

	public Integer saveUser(User user);
	public User getOneUserByEmail(String email);
}
