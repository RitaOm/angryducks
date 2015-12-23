package com.epam.jmp.util;

import java.util.List;

import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Cell;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;

public class LabyrinthUtils {

	private LabyrinthUtils() {
	}

	enum LabyrinthPoint {

		ENTRY, EXIT;

		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}

	}

	public static void addKeyPoints(Labyrinth labyrinth) {
		Cell entry = findLabyrinthPoint(labyrinth,
				LabyrinthPoint.ENTRY.toString());
		Cell exit = findLabyrinthPoint(labyrinth,
				LabyrinthPoint.EXIT.toString());
		labyrinth.setEntry(entry);
		labyrinth.setExit(exit);
	}
	
	public static Cell findLabyrinthPoint(Labyrinth labyrinth,
			String point) {
		Cell cell = new Cell();
		String symbol = Messages.getProperty(point);
		for (int i = 0; i < labyrinth.getRows(); i++) {
			for (int j = 0; j < labyrinth.getColumns(); j++) {
				if (labyrinth.getInstance()[i][j].equals(symbol)){
					cell.setX(j);
					cell.setY(i);
				}
			}
		}
		return cell;
	}
	
	public static LabyrinthLevel initLabyrinthLevel(int level) {
		switch (level) {
		case 1:
			return LabyrinthLevel.LEVEL1;	
		case 2:
			return LabyrinthLevel.LEVEL2;	
		default:
			return LabyrinthLevel.LEVEL1;
		}
	}

	public static boolean isDuckFinished(Duck duck, Labyrinth labyrinth) {
		if (labyrinth.getExit().getX() == duck.getCurrentCell().getX()
				&& labyrinth.getExit().getY() == duck.getCurrentCell().getY()) {
			return true;
		}
		return false;
	}
	
	public static void copyCellCoordinates (Cell toBeCopied, Cell c2){
		c2.setX(toBeCopied.getX());
		c2.setY(toBeCopied.getY());
	}


	public static boolean stringLinesLengthChecker(List<String> lines) {
		int length = lines.get(0).trim().length();
		for (String line : lines) {
			if (line.trim().length() != length) {
				return false;
			}
		}
		return true;
	}

	public static String[][] stringLinesToArrayConverter(List<String> lines) {
		String[][] labyrinthInstance;
		int rows = lines.size();
		int columns = lines.get(0).length();
		labyrinthInstance = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			String line = lines.get(i).trim();
			for (int j = 0; j < columns; j++) {
				labyrinthInstance[i][j] = line.substring(j, j + 1);
			}
		}
		return labyrinthInstance;
	}

}
