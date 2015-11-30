package com.epam.jmp.creator;

import com.epam.jmp.model.GameLevel;
import com.epam.jmp.model.labyrinth.Coordinates;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.util.CoordinatesOperations;

public abstract class LabyrinthBuilder {

	abstract public Labyrinth build(GameLevel level);
	
	enum LabyrinthPoint {

		ENTRY, EXIT;

		@Override
		public String toString() {
			return super.toString().toLowerCase();
		}

	}
	
	public void addKeyPoints(Labyrinth labyrinth){
		Coordinates entry = CoordinatesOperations.findLabyrinthPoint(labyrinth.getLabyrinthInstance(),
				LabyrinthPoint.ENTRY.toString());
		Coordinates exit = CoordinatesOperations.findLabyrinthPoint(labyrinth.getLabyrinthInstance(),
				LabyrinthPoint.EXIT.toString());
		labyrinth.setEntry(entry);
		labyrinth.setExit(exit);
	}
	
	
}
