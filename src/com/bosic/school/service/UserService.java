package com.bosic.school.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bosic.school.domain.User;
import com.bosic.school.domain.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user){
		userRepository.save(user);
	}
	
	public void delete(Integer id){
		userRepository.delete(id);
	}
	
	public User findOne(Integer id){
		return userRepository.findOne(id);
	}
	
	public Long count(){
		return userRepository.count();
	}
	
	public Page<User> findAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}
	
	public Page<User> findByUsername(String username, Pageable pageable){
		return userRepository.findAllByUsername(username, pageable);
	}
}
