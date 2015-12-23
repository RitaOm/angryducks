package com.epam.jmp.model;

import java.util.List;

import com.epam.jmp.client.ActionStatus;
import com.epam.jmp.client.ActionUtil;
import com.epam.jmp.client.ClientAction;
import com.epam.jmp.client.ClientInterface;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.util.LabyrinthUtils;

public class Game {

	private List<Duck> playingDucks;

	private Labyrinth labyrinth;

	private List<Duck> finishedDucks;

	public Game(List<Duck> players, Labyrinth labyrinth) {
		playingDucks = players;
		this.labyrinth = labyrinth;
		init();
	}

	private void init() {
		for (Duck duck : playingDucks) {
			LabyrinthUtils.copyCellCoordinates(labyrinth.getEntry(),
					duck.getCurrentCell());
		}
	}

	public void play() {
		while (playingDucks.size() > 0) {
			for (Duck duck : playingDucks) {
				List<String> actions = ActionUtil.getAvailableActions(duck,
						labyrinth);
				ClientInterface.offerActions(actions);
				String action = ClientInterface.chooseAction();
				ActionStatus result = ActionUtil.checkAction(action, actions);
				ClientInterface.concludeAction(result, duck);
				switch (result) {
				case LEFT:
					playingDucks.remove(duck);
					continue;
				case WRONG_ACTION:
					continue;
				case ACCEPTED:
					ClientAction clientAction = ActionUtil.recognizeAction(action);
					ActionUtil.executeAction(clientAction, duck);
				}
				if (LabyrinthUtils.isDuckFinished(duck, labyrinth)) {
					playingDucks.remove(duck);
					finishedDucks.add(duck);
					// сообщение
				}
			}
		}
		ClientInterface.displayFinishStand(finishedDucks);
	}

	public List<Duck> getPlayingDucks() {
		return playingDucks;
	}

	public Labyrinth getLabyrinth() {
		return labyrinth;
	}

	public List<Duck> getFinishedDucks() {
		return finishedDucks;
	}

}
