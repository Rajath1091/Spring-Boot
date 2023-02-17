package com.ty.spring_school_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.spring_school_app.dto.Cart;
import com.ty.spring_school_app.dto.Item;
import com.ty.spring_school_app.repo.CartRepo;

@Repository
public class CartDao {

	@Autowired
	private CartRepo repo;

	public Cart saveCart(Cart cart) {
		return repo.save(cart);
	}

	public Cart deleteCart(int id) {
		Cart cart = repo.findById(id).get();
		repo.deleteById(id);
		return cart;
	}

	public Cart getCart(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		return null;
	}

	public Cart updateCart(int id, Cart cart) {
		Cart dbCart = repo.findById(id).get();
		if (dbCart != null) {
			cart.setId(id);
			cart.setItems(dbCart.getItems());
			return repo.save(cart);
		}
		return null;
	}

}
