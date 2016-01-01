package com.epam.jmp.builder.labyrinth;

import java.util.List;

import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;
import com.epam.jmp.utils.LabyrinthUtils;
import com.epam.jmp.utils.PathManager;
import com.epam.jmp.utils.TxtFileReader;

public class FileLabyrinthBuilder implements ILabyrinthBuilder {

	@Override
	public Labyrinth build(LabyrinthLevel level) throws NotRightLabyrinthException {
		String filename = PathManager.getPathToTxtFileWihLabyrinth(level);
		List<String> lines = TxtFileReader.readLabyrinthFromTxtFile(filename);
		if (LabyrinthUtils.stringLinesLengthChecker(lines)) {
			Labyrinth labyrinth = new Labyrinth(
					LabyrinthUtils.stringLinesToArrayConverter(lines), level);
			return labyrinth;
		} else
			throw new NotRightLabyrinthException("Not right labyrinth format");
	}

}
