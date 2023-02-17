package com.ty.spring_school_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.spring_school_app.dao.EmployeeDao;
import com.ty.spring_school_app.dto.Employee;
import com.ty.spring_school_app.exception.IdNotFoundException;
import com.ty.spring_school_app.util.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		if (employee.getSalary() >= 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('A');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 30000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('C');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Employee daoEmployee = dao.saveEmployee(employee);
		if (daoEmployee != null) {
			structure.setMessage("Successfully Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(daoEmployee);
		}
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Employee daoEmployee = dao.deleteEmployee(id);
		if (daoEmployee != null) {
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoEmployee);
		}
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Employee>> getEmployee(int id) throws Exception {
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Employee daoEmployee = dao.getEmployee(id);
		if (daoEmployee != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoEmployee);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for "+id);
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(int id, Employee employee) {
		if (employee.getSalary() >= 10000 && employee.getSalary() <= 20000) {
			employee.setGrade('A');
		} else if (employee.getSalary() > 20000 && employee.getSalary() <= 30000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('C');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		Employee daoEmployee = dao.updateEmployee(id, employee);
		if (daoEmployee != null) {
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(daoEmployee);
		}
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
	}

}
