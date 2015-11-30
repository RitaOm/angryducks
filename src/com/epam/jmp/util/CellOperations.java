package com.epam.jmp.util;

import java.util.List;

import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Cell;
import com.epam.jmp.model.labyrinth.Labyrinth;

public class CellOperations {

	private CellOperations() {
	}

	public static Cell findLabyrinthPoint(List<String> labyrinth,
			String point) {
		Cell cell = new Cell();
		String symbol = PropertyManager.getProperty(point);
		for (int i = 0; i < labyrinth.size(); i++) {
			if (labyrinth.get(i).contains(symbol)) {
				cell.setX(labyrinth.get(i).indexOf(symbol));
				cell.setY(i);
			}
		}
		return cell;
	}

	public static boolean ifFinish(Duck duck, Labyrinth labyrinth) {
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


}
