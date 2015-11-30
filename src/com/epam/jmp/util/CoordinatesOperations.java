package com.epam.jmp.util;

import java.util.List;

import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Coordinates;
import com.epam.jmp.model.labyrinth.Labyrinth;

public class CoordinatesOperations {

	private CoordinatesOperations() {
	}

	public static Coordinates findLabyrinthPoint(List<String> labyrinth,
			String point) {
		Coordinates coordinates = new Coordinates();
		String symbol = PropertyManager.getProperty(point);
		for (int i = 0; i < labyrinth.size(); i++) {
			if (labyrinth.get(i).contains(symbol)) {
				coordinates.setX(labyrinth.get(i).indexOf(symbol));
				coordinates.setY(i);
			}
		}
		return coordinates;
	}

	public static boolean ifFinish(Duck duck, Labyrinth labyrinth) {
		if (labyrinth.getExit().getX() == duck.getCoordinates().getX()
				&& labyrinth.getExit().getY() == duck.getCoordinates().getY()) {
			return true;
		}
		return false;
	}
	
	public static void copyCoordinates (Coordinates toBeCopied, Coordinates c2){
		c2.setX(toBeCopied.getX());
		c2.setY(toBeCopied.getY());
	}


}
