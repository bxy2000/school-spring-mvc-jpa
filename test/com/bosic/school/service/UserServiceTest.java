package com.bosic.school.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bosic.school.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void testLogin(){
		boolean result = userService.login("admin", "1");
		
		System.out.println(result);
	}
	
	@Test
	public void testFindUserByUsername(){
		User user = userService.findUserByUsername("admin");
		
		System.out.println(user);
	}
	
	@Test
	public void testRegister(){
		userService.register(new User(null, "bxy", "123"));
	}
}
