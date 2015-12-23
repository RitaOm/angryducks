package com.epam.jmp.client;

public enum ClientAction {

	SNACK, BATTERY, MONEY, UP, DOWN, LEFT, RIGHT, EXIT;
	
	@Override
	public String toString() {
		return super.toString().substring(0, 1);
	}
	
}
