package com.epam.jmp.model.labyrinth;


public class Labyrinth {

	private final String[][] instance;
	
	private LabyrinthLevel level;
	
	private Cell entry;
	
	private Cell exit;
	
	private int rows;
	
	private int columns;
	
	public Labyrinth(String[][] labyrinth, LabyrinthLevel gameLevel) {
		instance = labyrinth;
		level = gameLevel;
		rows = instance.length;
		columns = instance[0].length;
	}

	public String[][] getInstance() {
		return instance;
	}
	
	public LabyrinthLevel getLevel() {
		return level;
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

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}	

}
