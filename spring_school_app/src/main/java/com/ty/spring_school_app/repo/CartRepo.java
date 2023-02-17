package com.ty.spring_school_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.spring_school_app.dto.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {

}
