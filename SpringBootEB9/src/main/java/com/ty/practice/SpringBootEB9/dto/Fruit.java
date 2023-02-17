package com.ty.practice.SpringBootEB9.dto;

public class Fruit {

	String name;
	int price;
	String origin;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", price=" + price + ", origin=" + origin + "]";
	}

}
