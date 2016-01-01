package com.epam.jmp.builder.labyrinth;

import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;

public interface ILabyrinthBuilder {

	Labyrinth build(LabyrinthLevel level) throws NotRightLabyrinthException;
	
}
