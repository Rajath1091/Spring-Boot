package com.ty.spring_school_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.spring_school_app.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
