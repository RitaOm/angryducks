package com.epam.jmp.model.duck;

import com.epam.jmp.model.labyrinth.Direction;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.utils.Messages;


public class ToyDuck extends Duck {
	
	private int availableBatteryQuantity;
	
	public ToyDuck(String name, int availableBatteryQuantity) {
		super(name);
		this.availableBatteryQuantity = availableBatteryQuantity;
	}

	@Override
	public void move(Labyrinth labyrinth, Direction direction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void superAbility () {	
		System.out.println(Messages.getProperty("duck.dance", getName()));
	}
	
	@Override
	public void refresh () {	
		availableBatteryQuantity --;
		System.out.println(Messages.getProperty("duck.charge", getName()));
	}
	
	@Override
	public boolean hasReserve(){
		return availableBatteryQuantity>0;
	}
	
	@Override
	public DuckType getDuckType() {
		return DuckType.TOY;
	}

	public void jump(int deltaX, int deltaY) {
		getCurrentCell().changeCoordinates(deltaX, deltaY);
		System.out.println(Messages.getProperty("duck.fly", getName()));
	}	

	public int getAvailableBatteryQuantity() {
		return availableBatteryQuantity;
	}

	@Override
	public String toString() {
		return "Toy duck " + getName() + getCurrentCell() + ". Have "+ availableBatteryQuantity
				 + " batteries and "+ getCounter() +" steps to discharge battery";
	}

}
