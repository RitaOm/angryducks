package com.epam.jmp.entity.duck;


public class ToyDuck extends Duck {
	
	private static float STEP_MEASURE = 0.5f;
	private int availableBatteryQuantity;
	
	public ToyDuck() {
		setStepMeasure(STEP_MEASURE);
	}
	
	public void flitter () {		
	}

	public int getAvailableBatteryQuantity() {
		return availableBatteryQuantity;
	}

	public void setAvailableBatteryQuantity(int availableBatteryQuantity) {
		this.availableBatteryQuantity = availableBatteryQuantity;
	}


}
