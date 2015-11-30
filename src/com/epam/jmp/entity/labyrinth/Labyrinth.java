package com.epam.jmp.entity.labyrinth;

import java.util.List;

public class Labyrinth {

	private List<String> labyrinthInstance;
	
	private Coordinates entry;
	
	private Coordinates exit;
	
	public Labyrinth(List<String> labyrinth, Coordinates entry, Coordinates exit) {
		labyrinthInstance = labyrinth;
		this.entry = entry;
		this.exit = exit;
	}

	public List<String> getLabyrinthInstance() {
		return labyrinthInstance;
	}

	public Coordinates getEntry() {
		return entry;
	}

	public Coordinates getExit() {
		return exit;
	}	

}
