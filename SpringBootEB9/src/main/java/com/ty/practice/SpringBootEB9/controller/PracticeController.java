package com.ty.practice.SpringBootEB9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.practice.SpringBootEB9.dto.Fruit;

@RestController
public class PracticeController {

	@GetMapping("/print")
	public String print() {
		return "API is hit....";
	}

	@GetMapping("/display")
	public String display() {
		return "Display API is printing.....";
	}
	
	@PostMapping("/fruit")
	public String getFruit(@RequestBody Fruit fruit) {
		System.out.println(fruit);
		return "Fruit object is received";
	}

}
