package com.ty.spring_school_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.spring_school_app.dao.StudentDao;
import com.ty.spring_school_app.dto.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentDao dao;

	@PostMapping("/save")
	public Student saveStudent(@RequestBody Student student) {
		return dao.saveStudent(student);
	}

	@DeleteMapping("/delete")
	public Student deleteStudent(@RequestParam int id) {
		return dao.deleteStudent(id);
	}

	@GetMapping("/get/{id}")
	public Student getStudent(@PathVariable int id) {
		return dao.getStudent(id);
	}

	@PutMapping("/update")
	public Student updateStudent(@RequestParam int id, @RequestBody Student student) {
		return dao.updateStudent(id, student);
	}

}
