package com.epam.jmp.util;

public class DuckUtil {

	public static int UNICODE_NUMBER_FIRST_LATIN_UPPERCASELETTER = 65;

	public static String NAME_FOR_UNNAMED_DUCKS = "?";

	private DuckUtil() {
	}

	/*
	 * a method for name generation for ducks on condition that the quantity or
	 * playing ducks is <=26
	 */
	public static String generateDuckNameFromId(int id) {
		if (id < 27) {
			return Character.toString((char) (id
					+ UNICODE_NUMBER_FIRST_LATIN_UPPERCASELETTER - 1));
		} else
			return NAME_FOR_UNNAMED_DUCKS;
	}
}
