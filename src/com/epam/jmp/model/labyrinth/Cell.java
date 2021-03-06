package com.epam.jmp.model.labyrinth;

//A class which encapsulates coordinates and content of one cell of labyrinth
public class Cell {

	// horizontal coordinate
	private int x;

	// vertical coordinate
	private int y;

	public Cell() {
	}

	public Cell(int x, int y) {
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

	public void changeCoordinates(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
	}

	@Override
	public String toString() {
		return " (" + x + ", " + y + ") ";
	}

}
