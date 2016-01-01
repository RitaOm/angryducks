package com.epam.jmp.client;

import java.util.List;
import java.util.Scanner;

import com.epam.jmp.action.ActionStatus;
import com.epam.jmp.model.labyrinth.Labyrinth;
import com.epam.jmp.model.labyrinth.LabyrinthLevel;
import com.epam.jmp.model.labyrinth.LabyrinthWalker;
import com.epam.jmp.utils.LabyrinthUtils;
import com.epam.jmp.utils.Messages;

public class PlayerInterface {
	
	private static Scanner scanIn = new Scanner(System.in);

	private static String SPACE = " ";

	private static String UNDERLINE = "_";

	private static String CELL = "   ";

	private static String DIVISION = "|";

	public static int askForPlayersQuantity() {
		System.out.println(Messages.getProperty("init.ask.players.quantity"));
		int quantity;
		quantity = scanIn.nextInt();	
		if (quantity > 26) {
			quantity = 26;
		}
		return quantity;
	}

	public static LabyrinthLevel askForLabyrinthLevel() {
		System.out.println(Messages.getProperty("init.ask.game.level"));
		int level;
		level = scanIn.nextInt();
		return LabyrinthUtils.initLabyrinthLevel(level);
	}

	public static void displayGameboard(List<? extends LabyrinthWalker> players, Labyrinth labyrinth) {
		String[][] currentLabyrynth = labyrinth.getInstance();
		for (int i = 0; i < labyrinth.getRows(); i++) {
			for (int j = 0; j < labyrinth.getColumns(); j++) {
				for (LabyrinthWalker player : players) {
					if (player.getCurrentCell().getY() == i
							&& player.getCurrentCell().getX() == j) {
						currentLabyrynth[i][j] = player.getName();
					}
				}
				System.out.print(currentLabyrynth[i][j] + SPACE);
			}
			System.out.println();
		}
	}

	public static void displayPlayerInfo(LabyrinthWalker player) {
		System.out.println(player.toString());
	}
	
	public static void displayMessageWithPlayerName(LabyrinthWalker player, String key) {
		System.out.println(Messages.getProperty(key, player.getName()));
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
	
	public static void displayPlayerBalance(LabyrinthWalker player) {
		System.out.println(Messages.getProperty("player.balance", player.getBalance(), player.getCurrency()));
	}
	

	public static void concludeAction(ActionStatus result, LabyrinthWalker player) {
		String key = result.toString() + ".conclude";
		if (result == ActionStatus.LEFT) {
			System.out.println(Messages.getProperty(key, player.getName()));
		} else {
			System.out.println(Messages.getProperty(key));
		}
	}

	public static void congratulateFinishedPlayer(LabyrinthWalker player) {
		System.out.println(Messages.getProperty("congratulation.player.finished", player.getName()));
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

	public static void displayFinishStand(List<LabyrinthWalker> players) {
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
