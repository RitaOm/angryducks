package com.epam.jmp.entity;

public class Labyrinth {
	
	private char [][] labyrinthInstance;
	
	public Labyrinth (char [][] labyrinth){
		labyrinthInstance = labyrinth;
	}

	public char[][] getLabyrinthInstance() {
		return labyrinthInstance;
	}
	
}
