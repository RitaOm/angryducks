package com.epam.jmp.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LabyrinthPropertyManager {

	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle("level1/denotation");

	private LabyrinthPropertyManager() {
	}

	public static String getProperty(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			//LOG.error(e.getMessage());
			return null;
		}
	}
}
