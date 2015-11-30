package com.epam.jmp.main;

import java.util.List;

import com.epam.jmp.creator.AliveDuckCreator;
import com.epam.jmp.creator.ToyDuckCreator;
import com.epam.jmp.entity.AliveDuck;
import com.epam.jmp.entity.ToyDuck;
import com.epam.jmp.util.LabyrinthReader;

public class GameRunner {

	public static void main(String[] args) {
		List<String> lines = LabyrinthReader.readFromTxtFile("src/labyrinth.txt");
		for (String line : lines) {
			System.out.println(line);
		}
	}

}
