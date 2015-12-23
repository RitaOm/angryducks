package com.epam.jmp.client;

import java.util.List;
import java.util.Scanner;

import com.epam.jmp.model.duck.Duck;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;
import com.epam.jmp.util.LabyrinthUtils;
import com.epam.jmp.util.Messages;

public class ClientInterface {
	
	private static Scanner scanIn = new Scanner(System.in);

	private static String SPACE = " ";

	private static String UNDERLINE = "_";

	private static String CELL = "   ";

	private static String DIVISION = "|";

	public static int askForPlayersQuantity() {
		System.out.println(Messages.getProperty("init.players.quantity"));
		int quantity;
		quantity = scanIn.nextInt();	
		if (quantity > 26) {
			quantity = 26;
		}
		return quantity;
	}

	public static LabyrinthLevel askForLabyrinthLevel() {
		System.out.println(Messages.getProperty("init.game.level"));
		int level;
		level = scanIn.nextInt();
		return LabyrinthUtils.initLabyrinthLevel(level);
	}

	public static void displayGameboard(List<Duck> players, Labyrinth labyrinth) {
		String[][] currentLabyrynth = labyrinth.getInstance();
		for (int i = 0; i < labyrinth.getRows(); i++) {
			for (int j = 0; j < labyrinth.getColumns(); j++) {
				for (Duck duck : players) {
					if (duck.getCurrentCell().getY() == i
							&& duck.getCurrentCell().getX() == j) {
						currentLabyrynth[i][j] = duck.getName();
					}
				}
				System.out.print(currentLabyrynth[i][j] + SPACE);
			}
			System.out.println();
		}
	}

	public static void displayPlayerInfo(Duck duck) {
		System.out.println(duck.toString());
	}

	public static void offerActions(List<String> actions) {
		System.out.println(Messages.getProperty("available.actions"));
		for (String action : actions) {
			System.out.println(Messages.getProperty("action." + action));
		}
	}

	public static String chooseAction() {
		String letter;
		Scanner scanIn = new Scanner(System.in);
		letter = scanIn.nextLine();
		scanIn.close();
		if (letter == null) {
			return "";
		}
		return letter.trim();
	}

	public static void congratulateFinishedPlayer(Duck duck) {
		System.out.println(Messages.getProperty("congratulation.player.finished", duck.getName()));
	}

	public static void concludeAction(ActionStatus result, Duck duck) {
		String key = result.toString() + ".conclude";
		if (result == ActionStatus.LEFT) {
			System.out.println(Messages.getProperty(key, duck.getName()));
		} else {
			System.out.println(Messages.getProperty(key));
		}
	}

	private static String createSpace(int number, int addSpace) {
		String result;
		if (addSpace > 0) {
			result = SPACE;
		} else {
			result = "";
		}
		if (number == 0) {
			return result;
		}
		result += CELL;
		if (addSpace >= 0) {
			result += SPACE;
		}
		for (int i = 1; i < number; i++) {
			result += CELL + SPACE;
		}
		return result;
	}

	public static void displayFinishStand(List<Duck> players) {
		int first = players.size() / 2;
		int last = players.size() / 2;
		System.out.println(createSpace(first, 1) + UNDERLINE
				+ players.get(0).getName() + UNDERLINE);
		for (int i = 1; i < players.size(); i++) {
			if (i % 2 == 1) {
				System.out.println(createSpace(first - 1, 1) + UNDERLINE
						+ players.get(i).getName() + UNDERLINE + DIVISION
						+ createSpace(last - first + 1, -1) + DIVISION);
				first--;
			} else {
				System.out.println(createSpace(first, 0) + DIVISION
						+ createSpace(last - first + 1, -1) + DIVISION
						+ UNDERLINE + players.get(i).getName() + UNDERLINE);
				last++;
			}
		}
		System.out.println(DIVISION + createSpace(last - first + 1, -1)
				+ DIVISION);
	}
}
