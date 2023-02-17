package com.ty.spring_school_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.spring_school_app.dto.Item;
import com.ty.spring_school_app.repo.ItemRepo;

@Repository
public class ItemDao {
	
	@Autowired
	private ItemRepo repo;
	
	public Item updateItem(int id,Item item) {
		Item dbItem=repo.findById(id).get();
		if(dbItem!=null) {
			item.setId(id);
			return repo.save(item);
		}
		return null;
	}

}
