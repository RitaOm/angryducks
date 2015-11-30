package com.epam.jmp.entity.labyrinth;

//A class which encapsulates data about position of duck on the labyrinth at this time
public class Coordinates {

	//horizontal coordinate 
	private int x;
	
	//vertical coordinate 	
	private int y;
	
	public Coordinates(){
	}


	public Coordinates(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "( " + x + ", " + y + ")";
	}
	
	
	
}
