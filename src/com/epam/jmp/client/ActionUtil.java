package com.epam.jmp.client;

import java.util.ArrayList;
import java.util.List;

import com.epam.jmp.model.duck.AliveDuck;
import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.duck.ToyDuck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.util.Messages;

public class ActionUtil {

	private ActionUtil() {
	}

	public static List<String> getAvailableActions(Duck duck,
			Labyrinth labyrinth) {
		List<String> actions = new ArrayList<String>();
		int x = duck.getCurrentCell().getX();
		int y = duck.getCurrentCell().getY();
		if (duck.getCounter() <= 1) {
			if (duck instanceof AliveDuck) {
				AliveDuck aDuck = (AliveDuck) duck;
				if (aDuck.getAvailableSnackQuantity() > 0) {
					actions.add(ClientAction.SNACK.toString());
				} else {
					actions.add(ClientAction.MONEY.toString());
				}
			} else if (duck instanceof ToyDuck) {
				ToyDuck tDuck = (ToyDuck) duck;
				if (tDuck.getAvailableBatteryQuantity() > 0) {
					actions.add(ClientAction.BATTERY.toString());
				} else {
					actions.add(ClientAction.MONEY.toString());
				}
			}
		} else {
			if (y != 0 && !compare(labyrinth, x, y - 1, "wall")) {
				actions.add(ClientAction.UP.toString());
			}
			if (x != 0 && !compare(labyrinth, x - 1, y, "wall")) {
				actions.add(ClientAction.LEFT.toString());
			}
			if (y < labyrinth.getRows()
					&& !compare(labyrinth, x, y + 1, "wall")) {
				actions.add(ClientAction.DOWN.toString());
			}
			if (x < labyrinth.getColumns()
					&& !compare(labyrinth, x + 1, y, "wall")) {
				actions.add(ClientAction.RIGHT.toString());
			}
		}
		return actions;
	}

	private static boolean compare(Labyrinth labyrinth, int x, int y, String key) {
		return labyrinth.getInstance()[y][x].equals(Messages
				.getProperty(key));
	}

	public static ClientAction recognizeAction(String action) {
		switch (action.toUpperCase()) {
		case "E":
			return ClientAction.EXIT;
		case "S":
			return ClientAction.SNACK;
		case "B":
			return ClientAction.BATTERY;
		case "M":
			return ClientAction.MONEY;
		case "U":
			return ClientAction.UP;
		case "D":
			return ClientAction.DOWN;
		case "L":
			return ClientAction.LEFT;
		case "R":
			return ClientAction.RIGHT;
		default:
			return null;
		}
	}
	
	public static ActionStatus checkAction(String action, List<String> actions) {
		if (ClientAction.EXIT.toString().equals(action)) {
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

	public static void executeAction(ClientAction action, Duck duck) {

	}

}
