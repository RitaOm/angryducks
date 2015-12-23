package com.epam.jmp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.epam.jmp.client.ActionStatus;
import com.epam.jmp.client.ActionUtil;
import com.epam.jmp.client.ClientInterface;
import com.epam.jmp.creator.GameIntializer;
import com.epam.jmp.creator.duck.AliveDuckCreator;
import com.epam.jmp.creator.duck.IDuckListBuilder;
import com.epam.jmp.creator.duck.RandomDuckListBuilder;
import com.epam.jmp.creator.duck.ToyDuckCreator;
import com.epam.jmp.creator.labyrinth.FileLabyrinthBuilder;
import com.epam.jmp.creator.labyrinth.ILabyrinthBuilder;
import com.epam.jmp.creator.labyrinth.NotRightLabyrinthException;
import com.epam.jmp.model.Game;
import com.epam.jmp.model.duck.AliveDuck;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.duck.ToyDuck;
import com.epam.jmp.model.labyrinth.Cell;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;


public class GameRunner {

	public static void main(String[] args) throws NotRightLabyrinthException {
		int playersQuantity = ClientInterface.askForPlayersQuantity();
		LabyrinthLevel level = ClientInterface.askForLabyrinthLevel();
		IDuckListBuilder duckListBuilder = new RandomDuckListBuilder();
		ILabyrinthBuilder builder = new FileLabyrinthBuilder();
		Game game = GameIntializer.initNewGame(playersQuantity, duckListBuilder, level, builder);
		Cell currentCell = new Cell (2,3);
		game.getPlayingDucks().get(1).setCurrentCell(currentCell);
		ClientInterface.displayGameboard(game.getPlayingDucks(), game.getLabyrinth());
		ClientInterface.congratulateFinishedPlayer(game.getPlayingDucks().get(1));
		}
		
/*	AliveDuck ad = new AliveDuckCreator().createSimpleDuck();
	ToyDuck td = new ToyDuckCreator().createSimpleDuck();
	AliveDuck ad2 = new AliveDuckCreator().createSimpleDuck();
	List<Duck> players = new ArrayList<Duck>();
	players.add(ad);
	players.add(td);
	players.add(ad2);
	Cell currentCell = new Cell (2,3);
	ad.setCurrentCell(currentCell);
	ad.setCounter(10);
	currentCell = new Cell (4,8);
	td.setCurrentCell(currentCell);
	td.setCounter(10);
	ad2.setCounter(7);
	//ClientInterface.displayGameboard(players, game.getLabyrinth());
	Random random = new Random();
	for (Duck d: players){
		System.out.print("duck"+d.getName()+": ");
		System.out.println(random.nextInt(2));
		ActionStatus status = ActionStatus.LEFT;
		switch (status) {
		case LEFT:
			System.out.println(status);
			continue;
		case WRONG_ACTION:
			System.out.println(status);
			continue;
		case ACCEPTED:
			System.out.println(status);
		}
		List<String> actions = ActionUtil.getAvailableActions(d, game.getLabyrinth());
		if (d.getName().equals("B")){
			System.out.println("continue");
			continue;
		}
		for (String l:actions){
			System.out.print(l+" ");
		}
		System.out.println();
		ClientInterface.offerActions(actions);	*/
	
		//ClientInterface.displayDuckInfo(ad);
/*		String filename = PathManager.getPathToTxtFileWihLabyrinth(GameLevel.LEVEL1);
		List<String> lines = TxtFileReader.readLabyrinthFromTxtFile(filename);
		String[][] labyrinthInstance = LabyrinthUtils.stringLinesToArrayConverter(lines);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 25; j++) {
				System.out.print(labyrinthInstance[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(labyrinthInstance.length +","+labyrinthInstance[0].length);*/

}
