package com.epam.jmp.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LabyrinthReader {

	private LabyrinthReader() {
	}

	public static List<String> readFromTxtFile(String filename) {
		List<String> lines = new ArrayList<String>();
		try {
			lines = Files.readAllLines(Paths.get(filename),
					Charset.defaultCharset());
		} catch (IOException e) {
			System.out.println("An IO problem when reading " + filename + ". "
					+ e.getMessage());
		}
		return lines;
	}

}
