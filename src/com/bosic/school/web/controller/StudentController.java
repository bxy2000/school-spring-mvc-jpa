package com.bosic.school.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bosic.school.domain.Student;
import com.bosic.school.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController{
	@Autowired
	private StudentService studentService;

	@RequestMapping(value={"", "/index", "/index/{id}"})
	public String index(
			@PathVariable(required=false) Integer id,
			Model model) throws Exception {
		id = id == null ? 1 : id;
		
		int pageSize = 20;
		
		Page<Student> students = studentService.findAll(new PageRequest((id-1), pageSize));
		model.addAttribute("students", students);
		return "student/index";
	}
	
	@RequestMapping("/create")
	public String create(){
		return "student/create";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		Student student = studentService.findOne(id);
		
		model.addAttribute("model", student);
		
		return "student/edit";
	}
	
	@RequestMapping("/save")
	public String save(Student student){
		
		studentService.save(student);
		
		return "redirect:/student/index";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(
			@PathVariable Integer id,
			Model model) throws Exception {
		
		studentService.delete(id);
		
		return "redirect:/student/index";
	}
}
