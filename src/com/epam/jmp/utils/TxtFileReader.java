package com.epam.jmp.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReader {

	private TxtFileReader() {
	}

	public static List<String> readLabyrinthFromTxtFile(String filename) {
		List<String> lines = new ArrayList<String>();
		try {
			lines = Files.readAllLines(Paths.get(filename),
					Charset.defaultCharset());
		} catch (IOException e) {
			System.out.println("IO problem with " + filename + ": "
					+ e.getMessage());
		}
		return lines;
	}

}
