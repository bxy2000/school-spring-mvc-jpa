package com.bosic.school.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	Page<Student> findAllByStudentNameLike(String studentName, Pageable pageable);
}
