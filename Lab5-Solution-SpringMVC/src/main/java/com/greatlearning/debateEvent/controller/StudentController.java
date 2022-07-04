package com.greatlearning.debateEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.debateEvent.entity.Student;
import com.greatlearning.debateEvent.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	public StudentService studentService;

	@RequestMapping("/list")
	public String findAll(Model model) {
		List<Student> studentList = studentService.findAll();
		model.addAttribute("student", studentList);
		return "Students";
	}

	@RequestMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("country") String country,
			@RequestParam("department") String department) {

		Student student = null;
		if ((id != -1)) {
			student = studentService.findByid(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCountry(country);
			student.setDepartment(department);
		} else
			student = new Student(firstName, lastName, country,department );
		studentService.save(student);
		return "redirect:list";
	}

	@RequestMapping("/addStudent")
	public String addStudent(@RequestParam("id") int id, Model model) {

		if ((id != -1)) {
			Student student = studentService.findByid(id);
			model.addAttribute("student", student);
		} else {
			Student student = new Student();
			student.setId(-1);
			model.addAttribute("student", student);
		}
		return "StudentForm";
	}

	@RequestMapping("/deleteStudent")
	public String delete(@RequestParam("id") int id) {

		Student student = null;
		if ((id != -1)) {
			student = studentService.findByid(id);
			studentService.delete(student);
		}
		return "redirect:list";
	}

	
	  @RequestMapping("/search") 
	  public String findByfirstName_country(@RequestParam("firstName")String firstName,Model model) { 
		  List<Student> studList=studentService.findByfirstName_country(firstName);
	  System.out.println(studList); 
	  if(studList.size()!=0)
	  model.addAttribute("student", studList); 
	  else 
		  model.addAttribute("error","No students Found"); 
	  return "Students"; 
	  }
	 
}
