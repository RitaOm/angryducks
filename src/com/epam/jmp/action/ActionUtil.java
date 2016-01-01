package com.epam.jmp.action;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.model.duck.AliveDuck;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.duck.DuckType;
import com.epam.jmp.model.duck.ToyDuck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.WalkerStatus;
import com.epam.jmp.utils.LabyrinthUtils;
import com.epam.jmp.utils.StepMaker;

public class ActionUtil {
	
	private static String DOLLAR = "dollar";
	
	private ActionUtil() {
	}

	public static List<String> getAvailableActions(Duck duck,
			Labyrinth labyrinth) {
		List<String> actions = new ArrayList<String>();
		if (duck.getCounter() <= 1) {
			if (!duck.hasReserve()) {
				actions.add(Action.MONEY.toString());
			} else if (duck.getDuckType() == DuckType.ALIVE) {
				actions.add(Action.SNACK.toString());
			} else if (duck.getDuckType() == DuckType.TOY) {
				actions.add(Action.BATTERY.toString());
			}
		} else {
			if (LabyrinthUtils.isUpAvailable(labyrinth, duck)) {
				actions.add(Action.UP.toString());
			}
			if (LabyrinthUtils.isLeftAvailable(labyrinth, duck)) {
				actions.add(Action.LEFT.toString());
			}
			if (LabyrinthUtils.isDownAvailable(labyrinth, duck)) {
				actions.add(Action.DOWN.toString());
			}
			if (LabyrinthUtils.isRightAvailable(labyrinth, duck)) {
				actions.add(Action.RIGHT.toString());
			}
		}
		actions.add(Action.EXIT.toString());
		return actions;
	}

	public static Action recognizeAction(String action) {
		switch (action.toUpperCase()) {
		case "E":
			return Action.EXIT;
		case "S":
			return Action.SNACK;
		case "B":
			return Action.BATTERY;
		case "M":
			return Action.MONEY;
		case "U":
			return Action.UP;
		case "D":
			return Action.DOWN;
		case "L":
			return Action.LEFT;
		case "R":
			return Action.RIGHT;
		default:
			return null;
		}
	}

	public static ActionStatus checkAction(String action, List<String> actions) {
		if (Action.EXIT.toString().equals(action)) {
			return ActionStatus.LEFT;
		}
		boolean isRightAction = false;
		for (String availableAction : actions) {
			if (availableAction.equalsIgnoreCase(action)) {
				isRightAction = true;
			}
		}
		if (!isRightAction) {
			return ActionStatus.WRONG_ACTION;
		}
		return ActionStatus.ACCEPTED;
	}

	public static ActionResult executeAction(Action action, Duck duck,
			Labyrinth labyrinth) {
		duck.makeAStep();
		switch (action) {
		case SNACK:
		case BATTERY:
			if (!duck.hasReserve()) {
				duck.refresh();
				duck.setFullCounter();
				return ActionResult.SUCCESS;
			} 
		case MONEY:
			duck.pay(5, DOLLAR);
			duck.setFullCounter();
			return ActionResult.SUCCESS;
		case UP:			
		case DOWN:			
		case LEFT:			
		case RIGHT:
			if (LabyrinthUtils.isMovingToDirectionAvailable(labyrinth, duck, action)) {
				StepMaker.doStep(labyrinth, duck, action);
				return ActionResult.SUCCESS;
			} else {
				return ActionResult.FAILURE;
			}
		case EXIT:
			duck.setStatus(WalkerStatus.LEFT);
		default:
			return ActionResult.SUCCESS;
		}
	}
	
	//ClientInterface.displayMessageWithPlayerName(duck, "duck.has.no.battery");
	
}
