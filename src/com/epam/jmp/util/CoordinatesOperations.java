package com.epam.jmp.util;

import com.epam.jmp.entity.duck.Duck;
import com.epam.jmp.entity.labyrinth.Coordinates;
import com.epam.jmp.entity.labyrinth.Labyrinth;

public class CoordinatesOperations {

	private CoordinatesOperations() {
	}

	public static Coordinates findLabyrinthPoint(Labyrinth labyrinth,
			String point) {
		Coordinates coordinates = new Coordinates();
		String symbol = LabyrinthPropertyManager.getProperty(point);
		for (int i = 0; i < labyrinth.getLabyrinthInstance().size(); i++) {
			if (labyrinth.getLabyrinthInstance().get(i).contains(symbol)) {
				coordinates.setX(labyrinth.getLabyrinthInstance().get(i)
						.indexOf(symbol));
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

}
