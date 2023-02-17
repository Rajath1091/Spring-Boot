package com.ty.spring_school_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.spring_school_app.dao.CartDao;
import com.ty.spring_school_app.dto.Cart;
import com.ty.spring_school_app.exception.IdNotFoundException;
import com.ty.spring_school_app.util.ResponseStructure;

@RestController
public class CartController {

	@Autowired
	private CartDao dao;

	@PostMapping("/savecart")
	public ResponseEntity<ResponseStructure<Cart>> saveCart(@RequestBody Cart cart) {
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart dbCart = dao.saveCart(cart);
		if (dbCart != null) {
			structure.setMessage("Successfully Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dbCart);
		}
		return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletecart")
	public ResponseEntity<ResponseStructure<Cart>> deleteCart(@RequestParam int id) {
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart dbCart = dao.deleteCart(id);
		if (dbCart != null) {
			structure.setMessage("Successfully Deleted");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
		}
		return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.OK);
	}

	@GetMapping("/getcart/{id}")
	public ResponseEntity<ResponseStructure<Cart>> getCart(@PathVariable int id) throws IdNotFoundException {
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart dbCart = dao.getCart(id);
		if (dbCart != null) {
			structure.setMessage("Found");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
			return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("id not found for " + id);
		}

	}

	@PutMapping("/updatecart")
	public ResponseEntity<ResponseStructure<Cart>> updateCart(@RequestParam int id, @RequestBody Cart cart) {
		ResponseStructure<Cart> structure = new ResponseStructure<>();
		Cart dbCart = dao.updateCart(id, cart);
		if (dbCart != null) {
			structure.setMessage("Successfully Updated");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbCart);
		}
		return new ResponseEntity<ResponseStructure<Cart>>(structure, HttpStatus.OK);
	}

}
