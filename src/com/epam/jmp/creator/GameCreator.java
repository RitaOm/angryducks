package com.epam.jmp.creator;

import java.util.List;

import com.epam.jmp.builder.labyrinth.ILabyrinthBuilder;
import com.epam.jmp.builder.labyrinth.NotRightLabyrinthException;
import com.epam.jmp.creator.duck.list.IDuckListFiller;
import com.epam.jmp.creator.labyrinth.LabyrinthCreator;
import com.epam.jmp.model.Game;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;

public class GameCreator {
	
	private GameCreator() {
	}

	public static Game initNewGame(int playersQuantity, IDuckListFiller duckListBuilder, LabyrinthLevel level,
			ILabyrinthBuilder builder) throws NotRightLabyrinthException {
		List<Duck> players = duckListBuilder.buildDuckList(playersQuantity);
		Labyrinth labyrinth = LabyrinthCreator.newLabyrinth(builder, level);
		Game game = new Game(players, labyrinth);
		return game;
	}
}
