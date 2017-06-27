package com.bosic.school.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bosic.school.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void testSave() {
		for (int i = 0; i < 20; i++) {
			User user = new User(null, "bxy", "123");

			userService.save(user);
			
			System.out.println(user);
		}
	}

	@Test
	public void testDelete() {
		userService.delete(2);
	}

	@Test
	public void testFindOne() {
		User user = userService.findOne(1);
		System.out.println(user);
	}

	@Test
	public void testCount() {
		long count = userService.count();

		System.out.println(count);
	}

	@Test
	public void testFindAll() {
		Page<User> users = userService.findByUsername("bxy",new PageRequest(1, 10));
		for (User user : users) {
			System.out.println(user);
		}
	}
}
