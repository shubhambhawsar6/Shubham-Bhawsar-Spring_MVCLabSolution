package com.greatlearning.debateEvent.service;

import java.util.List;

import com.greatlearning.debateEvent.entity.Student;

public interface StudentService {

	 public List<Student> findAll();

	 public void save(Student student);
	 
	 public Student findByid(Integer id);

	public void delete(Student student);

	public List<Student> findByfirstName_country(String firstName);

	

}
