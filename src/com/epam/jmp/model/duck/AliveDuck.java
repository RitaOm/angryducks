package com.epam.jmp.model.duck;

import com.epam.jmp.util.Messages;

public class AliveDuck extends Duck {

	private int availableSnackQuantity;

	public AliveDuck() {
	}

	public void swim(int deltaX, int deltaY) {
		move(deltaX, deltaY);
		int c = getCounter();
		c--;
		setCounter(c);
		System.out.println(Messages.getProperty("duck.swim", getName()));
	}

	public void eat() {
		availableSnackQuantity--;
		System.out.println(Messages.getProperty("duck.eat", getName()));
	}

	public int getAvailableSnackQuantity() {
		return availableSnackQuantity;
	}

	public void setAvailableSnackQuantity(int availableSnackQuantity) {
		this.availableSnackQuantity = availableSnackQuantity;
	}

	@Override
	public String toString() {
		return "Alive duck " + getName() + getCurrentCell() + ". Have "
				+ availableSnackQuantity + " snacks and " + getCounter()
				+ " steps to get hungry";
	}

}
