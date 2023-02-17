package com.ty.spring_school_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.spring_school_app.dto.Employee;
import com.ty.spring_school_app.service.EmployeeService;
import com.ty.spring_school_app.util.ResponseStructure;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@PostMapping("/saveemp")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@DeleteMapping("/deleteemp")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int id) {
		return service.deleteEmployee(id);
	}

	@GetMapping("/getemp/{id}")
	public ResponseEntity<ResponseStructure<Employee>> getEmployee(@PathVariable int id) throws Exception {
		return service.getEmployee(id);
	}

	@PutMapping("/updateemp")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestParam int id,
			@RequestBody Employee employee) {
		return service.updateEmployee(id, employee);
	}

}
