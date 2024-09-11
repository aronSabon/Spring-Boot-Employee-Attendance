package com.lemon.service;

import com.lemon.model.User;

public interface UserService {

	
	void userSignup(User user);
	
	User userLogin(String un, String psw );
	User getbyEmail(String email);
	
}
