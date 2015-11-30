package com.epam.jmp.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;


public class PropertyManager {

	private final static ResourceBundle resourceBundle = ResourceBundle
			.getBundle(PathManager.PROPERTY_FILE_PATH);

	private PropertyManager() {
	}

	public static String getProperty(String key) {
		try {
			return resourceBundle.getString(key);
		} catch (MissingResourceException e) {
			// LOG.error(e.getMessage());
			return null;
		}
	}

}
