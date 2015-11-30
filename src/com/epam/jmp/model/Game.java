package com.epam.jmp.model;

import java.util.List;

import com.epam.jmp.client.ActionStatus;
import com.epam.jmp.client.ClientInterface;
import com.epam.jmp.creator.FileLabyrinthBuilder;
import com.epam.jmp.creator.LabyrinthBuilder;
import com.epam.jmp.creator.LabyrinthCreator;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.util.CellOperations;
import com.epam.jmp.util.ActionUtil;

public class Game {

	private List<Duck> playingDucks;

	private Labyrinth labyrinth;

	private List<Duck> finishedDucks;

	private GameLevel level;

	public Game(List<Duck> players, GameLevel level) {
		playingDucks = players;
		this.level = level;
		init();
	}

	private void init() {
		LabyrinthBuilder builder = new FileLabyrinthBuilder();
		labyrinth = LabyrinthCreator.newInstance(builder, level);
		for (Duck duck : playingDucks) {
			CellOperations.copyCellCoordinates(labyrinth.getEntry(),
					duck.getCurrentCell());
		}
	}
	
	public void play (){
		while (playingDucks.size() > 0){
			for (Duck duck : playingDucks){
				List<String> actions = ActionUtil.getAvailableActions(duck);
				ClientInterface.offerActions(actions);
				String action = ClientInterface.chooseAction(actions);// +choose
				ActionStatus result = ActionUtil.executeAction(action);
				ClientInterface.concludeAction(result);
				if (CellOperations.ifFinish(duck, labyrinth)){
					playingDucks.remove(duck);
					finishedDucks.add(duck);
				}
			}			
		}
		//ClientInterface finish - syso result
		
	}
	
}
