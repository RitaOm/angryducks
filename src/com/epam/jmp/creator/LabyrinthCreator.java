package com.epam.jmp.creator;

import com.epam.jmp.model.GameLevel;
import com.epam.jmp.model.labyrinth.Labyrinth;

public class LabyrinthCreator {

	public static Labyrinth newInstance(LabyrinthBuilder builder, GameLevel level){
		Labyrinth labyrinth = builder.build(level);
		builder.addKeyPoints(labyrinth);
		return labyrinth;
	}
}
