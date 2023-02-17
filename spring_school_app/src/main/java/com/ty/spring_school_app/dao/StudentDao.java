package com.ty.spring_school_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.spring_school_app.dto.Student;
import com.ty.spring_school_app.repo.StudentRepo;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public Student deleteStudent(int id) {
		Student student = repo.findById(id).get();
		repo.deleteById(id);
		return student;
	}

	public Student getStudent(int id) {
		return repo.findById(id).get();
	}

	public Student updateStudent(int id, Student student) {
		Student dbStudent = repo.findById(id).get();
		if (dbStudent != null) {
			student.setId(id);
			return repo.save(student);
		} else {
			return null;
		}
	}

}
