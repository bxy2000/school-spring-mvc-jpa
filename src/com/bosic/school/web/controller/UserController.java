package com.bosic.school.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bosic.school.domain.User;
import com.bosic.school.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index/{id}")
	public String index(@PathVariable Integer id, Model model) throws Exception {
		Page<User> users = userService.findAll(new PageRequest(id-1, 10));
		System.out.println(users);
		model.addAttribute("users", users);
		
		return "user/index";
	}
}
