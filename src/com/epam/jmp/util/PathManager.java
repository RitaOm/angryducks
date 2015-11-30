package com.epam.jmp.util;

import com.epam.jmp.model.GameLevel;

public class PathManager {

	private static String SRC_PATH = "src/";
	private static String LABYRINTH_FILE_PATH = "/labyrinth.txt";
	public static String PROPERTY_FILE_PATH = "properties.denotation";

	private PathManager() {
	}

	public static String getPathToTxtFileWihLabyrinth(GameLevel level) {
		return SRC_PATH + level + LABYRINTH_FILE_PATH;
	}
	
}
