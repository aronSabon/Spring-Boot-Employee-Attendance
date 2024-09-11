package com.lemon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.model.User;
import com.lemon.repository.UserRepository;
import com.lemon.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository userRepo;
	@Override
	public void userSignup(User user) {
		userRepo.save(user);
	}

	@Override
	public User userLogin(String email, String psw) {
		
		return userRepo.findByEmailAndPassword(email, psw);
	}

	@Override
	public User getbyEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}



}
