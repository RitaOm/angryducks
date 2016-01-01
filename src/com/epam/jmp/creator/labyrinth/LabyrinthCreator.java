package com.epam.jmp.creator.labyrinth;

import com.epam.jmp.builder.labyrinth.ILabyrinthBuilder;
import com.epam.jmp.builder.labyrinth.NotRightLabyrinthException;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;
import com.epam.jmp.utils.LabyrinthUtils;

public class LabyrinthCreator {

	public static Labyrinth newLabyrinth(ILabyrinthBuilder builder, LabyrinthLevel level) throws NotRightLabyrinthException{
		Labyrinth labyrinth = builder.build(level);
		LabyrinthUtils.addKeyPoints(labyrinth);
		return labyrinth;
	}
}
