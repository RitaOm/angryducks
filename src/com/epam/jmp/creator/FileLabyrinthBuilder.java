package com.epam.jmp.creator;

import java.util.List;

import com.epam.jmp.model.GameLevel;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.util.PathManager;
import com.epam.jmp.util.TxtFileReader;

public class FileLabyrinthBuilder extends LabyrinthBuilder {

	@Override
	public Labyrinth build(GameLevel level) {
		String filename = PathManager.getPathToTxtFileWihLabyrinth(level);
		List<String> lines = TxtFileReader.readLabyrinthFromTxtFile(filename);
		Labyrinth labyrinth = new Labyrinth(lines);
		return labyrinth;
	}

}
