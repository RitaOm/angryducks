package com.epam.jmp.action;

public enum Action {

	SNACK, BATTERY, MONEY, UP, DOWN, LEFT, RIGHT, EXIT;
	
	@Override
	public String toString() {
		return super.toString().substring(0, 1);
	}
	
}
