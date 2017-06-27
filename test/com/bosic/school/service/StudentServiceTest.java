package com.bosic.school.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bosic.school.domain.Student;
import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testFindAllByStudentName(){
		Page<Student> student = studentService.findAllByStudentName("%三%", new PageRequest(0, 10));
		
		student.forEach(u->System.out.println(u));
	}
}
