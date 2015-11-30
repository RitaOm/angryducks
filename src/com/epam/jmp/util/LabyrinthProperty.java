package com.epam.jmp.util;

public enum LabyrinthProperty {

	ENTRY, EXIT, WALL, WAY, WATER;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
	
}
