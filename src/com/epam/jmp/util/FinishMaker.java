package com.epam.jmp.util;

import java.util.List;

import com.epam.jmp.model.duck.Duck;

public class FinishMaker {

	private FinishMaker() {
	}

	public static void make(List<Duck> players) {
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

	public static String repeat(String str, int number) {
		String result = str;
		for (int i = 0; i < number; i++) {
			result += str;
		}
		return result;
	}

}
