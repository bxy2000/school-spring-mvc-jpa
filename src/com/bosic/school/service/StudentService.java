package com.bosic.school.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bosic.school.domain.Student;
import com.bosic.school.domain.StudentRepository;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public void save(Student student){
		studentRepository.save(student);
	}
	
	public void delete(Integer id){
		studentRepository.delete(id);
	}
	
	public void delete(Iterable<Student> students){
		studentRepository.delete(students);
	}
	
	public Student findOne(Integer id){
		return studentRepository.findOne(id);
	}
	
	public Page<Student> findAll(Pageable pageable){
		return studentRepository.findAll(pageable);
	}
	
	public Page<Student> findAllByStudentName(String studentName, Pageable pageable){
		return studentRepository.findAllByStudentNameLike(studentName, pageable);
	}
}
