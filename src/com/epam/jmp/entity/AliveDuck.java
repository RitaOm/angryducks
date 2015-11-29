package com.epam.jmp.entity;

public class AliveDuck extends Duck {
	
	private int availableSnackQuantity;
	
	private int availableDrinkQuantity;
	
	public AliveDuck() {
	}
	
	public void fly () {}
	
	public void eat () {}

	public void drink () {}

	public int getAvailableSnackQuantity() {
		return availableSnackQuantity;
	}

	public void setAvailableSnackQuantity(int availableSnackQuantity) {
		this.availableSnackQuantity = availableSnackQuantity;
	}

	public int getAvailableDrinkQuantity() {
		return availableDrinkQuantity;
	}

	public void setAvailableDrinkQuantity(int availableDrinkQuantity) {
		this.availableDrinkQuantity = availableDrinkQuantity;
	}

}
