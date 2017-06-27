package com.bosic.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bosic.school.domain.User;
import com.bosic.school.domain.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public boolean login(String username, String password){
		User user = userRepository.findUserByUsername(username);
		
		return user != null && user.getPassword().equals(password);
	}
	
	public User findUserByUsername(String username){
		return userRepository.findUserByUsername(username);
	}
	
	@Transactional
	public void register(User user){
		userRepository.save(user);
	}
}
