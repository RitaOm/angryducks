package com.epam.jmp.model.duck;

import com.epam.jmp.model.labyrinth.Direction;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.utils.Messages;

public class AliveDuck extends Duck {

	private int availableSnackQuantity;

	public AliveDuck(String name, int availableSnackQuantity) {
		super(name);
		this.availableSnackQuantity = availableSnackQuantity;
	}

	@Override
	public void move(Labyrinth labyrinth, Direction direction) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void superAbility() {
		System.out.println(Messages.getProperty("duck.quack", getName()));
	}

	@Override
	public void refresh() {
		availableSnackQuantity--;
		System.out.println(Messages.getProperty("duck.eat", getName()));
	}
	
	@Override
	public boolean hasReserve(){
		return availableSnackQuantity>0;
	}
	
	@Override
	public DuckType getDuckType() {
		return DuckType.ALIVE;
	}

	public void swim(int deltaX, int deltaY) {
		getCurrentCell().changeCoordinates(deltaX, deltaY);
		System.out.println(Messages.getProperty("duck.swim", getName()));
	}

	public int getAvailableSnackQuantity() {
		return availableSnackQuantity;
	}

	@Override
	public String toString() {
		return "Alive duck " + getName() + getCurrentCell() + ". Have "
				+ availableSnackQuantity + " snacks and " + getCounter()
				+ " steps to get hungry";
	}



}
