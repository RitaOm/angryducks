package com.epam.jmp.main;

import com.epam.jmp.builder.labyrinth.FileLabyrinthBuilder;
import com.epam.jmp.builder.labyrinth.ILabyrinthBuilder;
import com.epam.jmp.builder.labyrinth.NotRightLabyrinthException;
import com.epam.jmp.client.PlayerInterface;
import com.epam.jmp.creator.GameCreator;
import com.epam.jmp.creator.duck.list.IDuckListFiller;
import com.epam.jmp.creator.duck.list.SimpleDuckListFiller;
import com.epam.jmp.model.Game;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;

public class GameRunner {

	public static void main(String[] args) throws NotRightLabyrinthException {
		LabyrinthLevel level = PlayerInterface.askForLabyrinthLevel();
		IDuckListFiller duckListBuilder = new SimpleDuckListFiller();
		ILabyrinthBuilder builder = new FileLabyrinthBuilder();
		Game game = GameCreator.initNewGame(2, duckListBuilder, level, builder);
		game.play();
	}

}
