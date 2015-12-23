package com.epam.jmp.model.duck;

import com.epam.jmp.util.Messages;


public class ToyDuck extends Duck {
	
	private static int STEP_MEASURE = 2;
	private int availableBatteryQuantity;
	
	public ToyDuck() {
		setStepMeasure(STEP_MEASURE);
	}
	
	public void fly(int deltaX, int deltaY) {
		move(deltaX, deltaY);
		int c = getCounter();
		c--;
		setCounter(c);
		System.out.println(Messages.getProperty("duck.fly", getName()));
	}
	
	public void chargeBattery () {	
		availableBatteryQuantity --;
		System.out.println(Messages.getProperty("duck.charge", getName()));
	}

	public int getAvailableBatteryQuantity() {
		return availableBatteryQuantity;
	}

	public void setAvailableBatteryQuantity(int availableBatteryQuantity) {
		this.availableBatteryQuantity = availableBatteryQuantity;
	}

	@Override
	public String toString() {
		return "Toy duck " + getName() + getCurrentCell() + ". Have "+ availableBatteryQuantity
				 + " batteries and "+ getCounter() +" steps to discharge battery";
	}

}
