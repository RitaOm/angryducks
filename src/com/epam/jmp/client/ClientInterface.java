package com.epam.jmp.client;

import java.util.List;

import com.epam.jmp.model.duck.Duck;

public class ClientInterface {

	public static void displayGameboard(List<Duck> players,
			List<String> labyrinth) {
		for (int i = 0; i < labyrinth.size(); i++) {
			String str = labyrinth.get(i);
			for (Duck duck : players) {
				if (duck.getCurrentCell().getY() == i) {
					str = str.substring(0, duck.getCurrentCell().getX())
							+ duck.getName()
							+ str.substring(duck.getCurrentCell().getX() + 1);
				}
			}
			System.out.println(str);
		}
	}

	public static void displayDuckInfo(Duck duck) {
		System.out.println("Duck " + duck.getName() + " : "
				+ duck.getCurrentCell());
	}

	public static void offerActions(List<String> actions) {
	}
	
	public static String chooseAction(List<String> actions) {
		return null;
	}
	
	public static void concludeAction(ActionStatus result){
		
	}
	
	public static void finish(List<Duck> players) {
		int first = players.size() / 2;
		int last = players.size() / 2;
		int p;
		System.out.println(repeat(" ", first - 1) + " "
				+ players.get(0).getName());
		for (int i = 1; i < players.size(); i++) {
			System.out.println(repeat(" ", first - 1) + "|"
					+ repeat(" ", last - first + 1) + "|");
			if (i % 2 == 1) {
				first++;
			} else {
				last--;
			}

		}
	}

	private static String repeat(String str, int number) {
		String result = str;
		for (int i = 0; i < number; i++) {
			result += str;
		}
		return result;
	}
}
