package com.epam.jmp.main;

import java.util.List;

import client.ClientAction;

import com.epam.jmp.creator.AliveDuckCreator;
import com.epam.jmp.creator.ToyDuckCreator;
import com.epam.jmp.entity.duck.AliveDuck;
import com.epam.jmp.entity.duck.ToyDuck;
import com.epam.jmp.util.LabyrinthPropertyManager;
import com.epam.jmp.util.TxtFileReader;

public class GameRunner {

	public static void main(String[] args) {
		AliveDuck ad = new AliveDuckCreator().createSimpleDuck();
		ToyDuck td = new ToyDuckCreator().createSimpleDuck();
		List<String> lines = TxtFileReader.readLabyrinthFromTxtFile("src/level1/labyrinth.txt");
	}

}
