package com.epam.jmp.model.labyrinth;

import java.util.List;

public class Labyrinth {

	private List<String> labyrinthInstance;
	
	private Coordinates entry;
	
	private Coordinates exit;
	
	public Labyrinth(List<String> labyrinth) {
		labyrinthInstance = labyrinth;
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

	public void setEntry(Coordinates entry) {
		this.entry = entry;
	}

	public void setExit(Coordinates exit) {
		this.exit = exit;
	}	
	
}
