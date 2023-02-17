package com.ty.spring_school_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.spring_school_app.dao.ItemDao;
import com.ty.spring_school_app.dto.Item;

@RestController
public class ItemController {
	
	@Autowired
	private ItemDao dao;
	
	@PutMapping("/updateitem")
	public Item updateItem(@RequestParam int id,@RequestBody Item item) {
		return dao.updateItem(id, item);
	}
	
}
