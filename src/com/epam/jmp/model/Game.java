package com.epam.jmp.model;

import java.util.List;

import com.epam.jmp.action.Action;
import com.epam.jmp.action.ActionResult;
import com.epam.jmp.action.ActionStatus;
import com.epam.jmp.action.ActionUtil;
import com.epam.jmp.client.PlayerInterface;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.WalkerStatus;
import com.epam.jmp.utils.LabyrinthUtils;

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
		for (Duck duck : playingDucks) {
			duck.setStatus(WalkerStatus.WALKING);
		}
		while (playingDucks.size() > 0) {
			for (Duck duck : playingDucks) {
				List<String> actions = ActionUtil.getAvailableActions(duck,
						labyrinth);
				PlayerInterface.offerActions(actions);
				String action = PlayerInterface.chooseAction();
				ActionStatus status = ActionUtil.checkAction(action, actions);
				PlayerInterface.concludeAction(status, duck);
				switch (status) {
				case LEFT:
					playingDucks.remove(duck);
					continue;
				case WRONG_ACTION:
					continue;
				case ACCEPTED:
					Action clientAction = ActionUtil.recognizeAction(action);
					ActionResult result = ActionUtil.executeAction(clientAction, duck, labyrinth);
					if (result == ActionResult.FAILURE){
						//сообщение типа But smth came wrong..
					}
				}				
				if (LabyrinthUtils.isDuckFinished(duck, labyrinth)) {
					playingDucks.remove(duck);
					duck.setStatus(WalkerStatus.FINISHED);
					finishedDucks.add(duck);
					// сообщение
				}
			}
		}
		//PlayerInterface.displayFinishStand(finishedDucks);
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
