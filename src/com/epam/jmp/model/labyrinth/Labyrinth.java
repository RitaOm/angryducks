package com.epam.jmp.model.labyrinth;

import java.util.List;

public class Labyrinth {

	private List<String> labyrinthInstance;
	
	private Cell entry;
	
	private Cell exit;
	
	public Labyrinth(List<String> labyrinth) {
		labyrinthInstance = labyrinth;
	}

	public List<String> getLabyrinthInstance() {
		return labyrinthInstance;
	}

	public Cell getEntry() {
		return entry;
	}

	public Cell getExit() {
		return exit;
	}

	public void setEntry(Cell entry) {
		this.entry = entry;
	}

	public void setExit(Cell exit) {
		this.exit = exit;
	}	
	
}
